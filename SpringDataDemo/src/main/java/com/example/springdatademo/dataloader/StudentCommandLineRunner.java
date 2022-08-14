package com.example.springdatademo.dataloader;

import com.example.springdatademo.model.Address;
import com.example.springdatademo.model.Course;
import com.example.springdatademo.model.Student;
import com.example.springdatademo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class StudentCommandLineRunner implements CommandLineRunner {
//    @Autowired
//    private StudentPersistence studentPersistence;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    DataloadService dataloadService;

    @Override
    public void run(String... args) throws Exception {
//        studentPersistence.saveStudent(new Student("Jack",30));
//        studentPersistence.saveStudent(new Student("John",33));
//        studentPersistence.saveStudent(new Student("Jill",27));
//        studentPersistence.saveStudent(new Student("Harry",28));
//        studentPersistence.saveStudent(new Student("Jonny",32));
       dataloadService.loadData();
//        System.out.println(studentRepository.findAll());
//        System.out.println(studentRepository.findById(1l));
//        System.out.println(studentRepository.findByName("Jack"));
//        System.out.println(studentRepository.findByName("Jill"));
//        System.out.println(studentRepository.findAllByGpaGreaterThan(30));
//        System.out.println(studentRepository.findFailing());
//        System.out.println(studentRepository.findStudentsThatPassed(29));
//        System.out.println(studentRepository.findStudentsThatPassedNative(29));
//        System.out.println(studentRepository.findAll(StudentSpecification.hasGPAMoreThan(29)));
//        System.out.println(studentRepository.findDistinctByEnrolCourses_CourseCode("EA"));
//        System.out.println(studentRepository.findAllByEnrolCourses_CourseCode("EA"));
//        System.out.println(courseRepository.findAllByEnrolStudents_Address_State("IA"));
//        System.out.println(courseRepository.findDistinctByEnrolStudents_Address_State("IA"));
//        System.out.println(courseRepository.findCourseEnrolByStudentAtState("IA"));
        System.out.println(studentRepository.findAll(StudentSpecification.hasCourseAsEAandLiveATNY()));
//        System.out.println("check" + studentRepository.findAll(StudentSpecification.hasCourseAsEAAndLiveATNY()));

    }


}
