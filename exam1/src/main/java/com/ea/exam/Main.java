package com.ea.exam;

import com.ea.exam.entity.*;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;

import java.util.List;

public class Main {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("examPU");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("Program start");
        main.seedData();
        main.returnHouseWithMoreThan10Employee();
        main.allOwnersOfHouseGt120k();
        main.getAllHouse10EmployeeCost500kInState();
        System.out.println("Program end");
    }

    public void returnHouseWithMoreThan10Employee(){
        String strQuery = "select h from House h where h.numberOfEmployee >= 10";
        TypedQuery<House> houseTypedQuery = entityManager.createQuery(strQuery,House.class);
        List<House> houseMoreThan10Employee = houseTypedQuery.getResultList();
        System.out.println("Query 1 Results : ");
        houseMoreThan10Employee.forEach(System.out::println);
    }

    public void getAllHouse10EmployeeCost500kInState(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<House> houseCriteriaQuery = cb.createQuery(House.class);
        Root<House> houseRoot = houseCriteriaQuery.from(House.class);

        Predicate employeeCountPredicate = cb.lessThan(houseRoot.get("numberOfEmployee"),8);
        Predicate houseCostPredicate = cb.gt(houseRoot.get("cost"),500000);

        Join<House, Owner> ownerJoin = houseRoot.join("houseOwner");
        Root<Owner> ownerRoot = houseCriteriaQuery.from(Owner.class);
        Root<Bank> bankRoot = cb.treat(ownerRoot,Bank.class);

        Predicate houseAddressPredicate = cb.equal(bankRoot.get("bankAddress").get("state"),"IA");
        Predicate andPredicate = cb.and(employeeCountPredicate,houseCostPredicate,houseAddressPredicate);
        houseCriteriaQuery.where(andPredicate);
        TypedQuery<House> houseTypedQuery = entityManager.createQuery(houseCriteriaQuery);
        List<House> houseList = houseTypedQuery.getResultList();
        System.out.println("Query 2 result");
        houseList.forEach(System.out::println);
    }

    public void allOwnersOfHouseGt120k(){
        String query = "select h.houseOwner from House h where h.cost >1200000";
        TypedQuery<Owner> houseOwnerTypedQuery = entityManager.createQuery(query,Owner.class);
        List<Owner> listOfHouseOwner = houseOwnerTypedQuery.getResultList();
        System.out.println("Query 6 result");
        listOfHouseOwner.forEach(System.out::println);
    }

    public void seedData(){
        EntityTransaction tx  = entityManager.getTransaction();
        tx.begin();
        Address midWestAddress = new Address();
        midWestAddress.setStreet("58 E Burlington");
        midWestAddress.setCity("Fairfield");
        midWestAddress.setState("IA");
        midWestAddress.setZipcode("52556");
        entityManager.persist(midWestAddress);

        Address usBankAddress = new Address();
        usBankAddress.setStreet("301 E Washington St");
        usBankAddress.setCity("Mount Pleasant");
        usBankAddress.setState("IA");
        usBankAddress.setZipcode("52641");
        entityManager.persist(usBankAddress);

        Bank midWestbank = new Bank();
        midWestbank.setName("MidWestOne");
        midWestbank.setBankAddress(midWestAddress);
        entityManager.persist(midWestbank);

         Bank usBank = new Bank();
         usBank.setName("USBank");
         usBank.setBankAddress(usBankAddress);
         entityManager.persist(usBank);

        Person jack = new Person();
        jack.setName("Jack");
        jack.setAge(32);
        entityManager.persist(jack);

         Person jill = new Person();
         jill.setName("Jill");
         jill.setAge(28);
         entityManager.persist(jill);
         Person jim = new Person();
         jim.setName("Jim");
         jim.setAge(40);
         entityManager.persist(jim);

         Person jasmin = new Person();
         jasmin.setName("Jasmin");
         jasmin.setAge(26);
         entityManager.persist(jasmin);

         House burlington = new House();
         burlington.setName("burlingtonHouse");
         burlington.setCost(120000);
         burlington.setHouseOwner(jack);
         burlington.setNumberOfEmployee(15);
         entityManager.persist(burlington);

         House briggHouse = new House();
         briggHouse.setName("briggsHouse");
         briggHouse.setCost(120000);
         briggHouse.setHouseOwner(jill);
         briggHouse.setNumberOfEmployee(15);
         entityManager.persist(briggHouse);

         House hempsteadHouse = new House();
         hempsteadHouse.setName("hempsteadHOuse");
         hempsteadHouse.setCost(500000);
         hempsteadHouse.setHouseOwner(jim);
         hempsteadHouse.setNumberOfEmployee(15);
         entityManager.persist(hempsteadHouse);

         House jasminHouse = new House();
         jasminHouse.setName("jasmin");
         jasminHouse.setCost(500000);
         jasminHouse.setHouseOwner(jasmin);
         jasminHouse.setNumberOfEmployee(15);
         entityManager.persist(jasminHouse);

        tx.commit();
    }


}
