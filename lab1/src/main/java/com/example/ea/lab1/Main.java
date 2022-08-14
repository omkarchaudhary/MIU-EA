package com.example.ea.lab1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Student");
   static EntityManager entityManager = entityManagerFactory.createEntityManager();
   static EntityTransaction entityTransaction = entityManager.getTransaction();

    public static void main(String[] args) {
        addJob();
        updateJob();
        deleteJob(1);
    }

    public static void addJob(){
        entityTransaction.begin();
        JobEntity jobEntity = new JobEntity();
        jobEntity.setId((long)1);
        jobEntity.setTitle("Developer");
        jobEntity.setSalary(1200.0);
        entityManager.persist(jobEntity);

        JobEntity jobEntity1 = new JobEntity();
        jobEntity1.setId((long)2);
        jobEntity1.setTitle("Senior Developer");
        jobEntity1.setSalary(1500.0);
        entityManager.persist(jobEntity1);

        entityTransaction.commit();
    }
    public static void updateJob(){
        JobEntity jobEntity = new JobEntity();
        entityTransaction.begin();
        JobEntity job = entityManager.find(JobEntity.class, (long)1);
        job.setTitle("Developers");
        job.setSalary(1200.0);
        entityTransaction.commit();
    }
    public static void deleteJob(long id){
        JobEntity jobEntity = new JobEntity();
        entityTransaction.begin();
        JobEntity job  = entityManager.find(JobEntity.class, id);
        entityManager.remove(job);
        entityTransaction.commit();
    }
}
