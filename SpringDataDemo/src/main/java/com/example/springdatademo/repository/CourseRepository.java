package com.example.springdatademo.repository;

import com.example.springdatademo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long>, JpaSpecificationExecutor<Course> {

    List<Course> findAllByEnrolStudents_Address_State(String state);

    List<Course> findDistinctByEnrolStudents_Address_State(String state);

    @Query("SELECT DISTINCT c FROM Course  c JOIN c.enrolStudents s WHERE s.address.state=?1")
    List<Course> findCourseEnrolByStudentAtState(String state);
}
