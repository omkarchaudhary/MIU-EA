package com.miu.ea.lab5.entity;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
        System.out.println("Program start");

        EntityTransaction entityTransaction = entityManager.getTransaction();

        //persist(entityTransaction);
        // Update
        //update(entityTransaction);
        //delete
        //remove(entityTransaction);

        studentHavingCourseEA();

        System.out.println("Program end");
    }

    private static void remove(EntityTransaction entityTransaction) {
        entityTransaction.begin();
        Student st2= entityManager.find(Student.class,2l);
        entityManager.remove(st2);
        entityTransaction.commit();
    }

    private static void update(EntityTransaction entityTransaction) {
        entityTransaction.begin();
        Student st1 = entityManager.find(Student.class,1l);
        st1.setName("John Updated");
        entityTransaction.commit();
    }

    private static void studentHavingCourseEA(){
        String str = "select s.student from Course s join Student c where s.courseName='EA'";
        Query query = entityManager.createQuery(str);
        List resultList = query.getResultList();
        System.out.println(resultList);
    }

    private static void persist(EntityTransaction entityTransaction) {
        entityTransaction.begin();

        Student john = new Student("John");
        //List<Course> johnCourse = Arrays.asList(ea,algo);
        //john.setCourse(johnCourse);
        entityManager.persist(john);

        Student jack = new Student("Jack");
        //List<Course> jackCourse = Arrays.asList(ea);
        //jack.setCourse(jackCourse);
        entityManager.persist(jack);

        Course ea = new Course();
        ea.setCourseName("EA");
        ea.setStudent(jack);
        entityManager.persist(ea);

        Course algo = new Course();
        algo.setCourseName("Algorithm");
        algo.setStudent(john);
        entityManager.persist(algo);

        Course algo1 = new Course();
        algo1.setCourseName("Algorithm");
        algo1.setStudent(jack);
        entityManager.persist(algo1);

        entityTransaction.commit();
    }

}
