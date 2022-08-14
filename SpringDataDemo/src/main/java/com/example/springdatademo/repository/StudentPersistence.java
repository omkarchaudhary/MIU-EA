package com.example.springdatademo.repository;

import com.example.springdatademo.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class StudentPersistence {

    @PersistenceContext
    private EntityManager em;

    public Long saveStudent(Student student){
        em.persist(student);
        return student.getId();
    }
}
