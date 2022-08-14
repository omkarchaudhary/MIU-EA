package com.miu.springdatajpademo;

import com.miu.springdatajpademo.entities.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentPersistence {
    @PersistenceContext
    EntityManager entityManager;
    public long addStudent(Student student){
        entityManager.persist(student);
        return student.getId();
    }
}
