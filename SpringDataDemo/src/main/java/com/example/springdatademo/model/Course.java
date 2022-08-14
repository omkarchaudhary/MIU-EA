package com.example.springdatademo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseCode;
    private String title;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "student_course",
            joinColumns = {
            @JoinColumn(name = "course_id",referencedColumnName = "id")
    },inverseJoinColumns = {
            @JoinColumn(name = "student_id",referencedColumnName = "id")
    })
    private List<Student> enrolStudents;

    public Course() {
    }

    public Course(String courseCode, String title) {
        this.courseCode = courseCode;
        this.title = title;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getEnrolStudents() {
        return enrolStudents;
    }

    public void setEnrolStudents(List<Student> enrolStudents) {
        this.enrolStudents = enrolStudents;
    }

    public void addEnrolStudents(Student student){
        if(this.enrolStudents==null){
            this.enrolStudents=new ArrayList<>();
        }
        this.enrolStudents.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseCode='" + courseCode + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
