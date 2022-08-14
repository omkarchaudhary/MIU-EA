package com.miu.firstspringdemo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class StudentRepo {
    private List<Student> studentList;

    public StudentRepo() {
        this.studentList = new ArrayList<>();
        studentList.add(new Student("omkar",4));
    }
    public void addStudent(Student student){
        if(student != null)
            studentList.add(student);
    }

    public List<Student> getStudentList(){
        return studentList;
    }

    public Student getStudent(int index){
        if(index >= 0 && index < studentList.size()){
            return studentList.get(index);
        }else {
            throw  new StudentNotFound("id  "+ index);
        }
    }

    public void deleteStudent(int id){
        studentList.remove(id);
    }
}
