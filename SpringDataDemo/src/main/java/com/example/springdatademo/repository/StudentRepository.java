package com.example.springdatademo.repository;

import com.example.springdatademo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>, JpaSpecificationExecutor<Student> {
    Student findByName(String name);
    List<Student> findAllByName(String name);
    List<Student> findAllByGpaGreaterThan(Integer gpa);

    List<Student> findFailing();

    private void a() {
        System.out.println("aa");
    }
    static void b(){
    }
    default void c(){
        a();
    }

    @Query("SELECT s FROM Student s WHERE s.gpa>=?1")
    List<Student> findStudentsThatPassed(Integer gpa);

    @Query(value = "SELECT * FROM STUDENT AS s WHERE s.gpa>=?1",nativeQuery = true)
    List<Student> findStudentsThatPassedNative(Integer passGpa);

    List<Student> findDistinctByEnrolCourses_CourseCode(String courseCode);
    List<Student> findAllByEnrolCourses_CourseCode(String courseCode);
}
