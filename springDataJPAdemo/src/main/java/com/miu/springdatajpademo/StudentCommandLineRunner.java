package com.miu.springdatajpademo;

import com.miu.springdatajpademo.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentCommandLineRunner implements CommandLineRunner {
    @Autowired
    StudentPersistence studentPersistence;
    @Autowired
    StudentRepository studentRepository;
    @Override
    public void run(String... args) throws Exception {
//        studentPersistence.addStudent(new Student("John",32));
//        studentPersistence.addStudent(new Student("Jack", 28));
        studentRepository.save(new Student("John",32));
        studentRepository.save(new Student("Jack",28));
        //Optional<Student> student = studentRepository.findById(1l);
        //Student student = studentRepository.findByName("Jack");
        //Student student = studentRepository.findByNameAndGpa("John",32);
        //List<Student> student = studentRepository.findStudentGreatGpa(20);
        //List<Student> student = studentRepository.findStudentGreatGPNamed();
        //List<Student> student = studentRepository.findStudentGreatGpaNative(30);
        //List<Student> student = studentRepository.findStudentGreatGPApi();
        List<Student> student = studentRepository.findAll(StudentSpecification.hasGpaMoreThan());

        System.out.println(student);
    }
}
