package com.miu.springdatajpademo;

import com.miu.springdatajpademo.entities.Student;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long>, JpaSpecificationExecutor<Student> {

    public Student findByName(String name);
    public Student findByNameAndGpa(String name, int gpa);

    @Query("SELECT s FROM Student s WHERE s.gpa > ?1")
    public List<Student> findStudentGreatGpa(int gpa);

    public List<Student> findStudentGreatGPNamed();

    @Query(value = "SELECT * FROM Student s WHERE s.gpa > ?1", nativeQuery = true)
    public List<Student> findStudentGreatGpaNative(int gpa);

    //public List<Student> findStudentGreatGPApi();

}
