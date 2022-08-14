package com.example.springdatademo.dataloader;

import com.example.springdatademo.model.Address;
import com.example.springdatademo.model.Course;
import com.example.springdatademo.model.Student;
import com.example.springdatademo.repository.CourseRepository;
import com.example.springdatademo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DataloadService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public void loadData(){
        Address address1 = new Address("1000N Street","Fairfield","IA","52557");
        Address address2 = new Address("800 S Main Street","Burlington","IA","52601");
        Address address3 = new Address("1000N Street","Fairfield","IA","52556");
        Address address4 = new Address("620 Eighth Avenue","New York","NY","10018");
        Address address5 = new Address("6200 Eighth Avenue","New York","NY","10034");
        Student student1 = studentRepository.save(new Student("Jack",30,address1));
        Student student2 = studentRepository.save(new Student("John",33,address2));
        Student student3 = studentRepository.save(new Student("Jill",27,address3));
        Student student4 = studentRepository.save(new Student("Harry",28,address4));
        Student student5 = studentRepository.save(new Student("Jonny",32,address5));

        Course course1 = new Course("MPP","Modern Programming Practices");
        course1.addEnrolStudents(student1);
        course1.addEnrolStudents(student2);
        course1.addEnrolStudents(student4);
        courseRepository.save(course1);
        Course course2 = new Course("EA","Enterprise Architecture");
        course2.addEnrolStudents(student5);
        course2.addEnrolStudents(student3);
        courseRepository.save(course2);
        Course course3 = new Course("SWA","Software Architecture");
        course3.addEnrolStudents(student1);
        course3.addEnrolStudents(student2);
        course3.addEnrolStudents(student5);
        courseRepository.save(course3);
    }
}
