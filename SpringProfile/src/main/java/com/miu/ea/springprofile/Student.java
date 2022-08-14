package com.miu.ea.springprofile;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

public class Student {
    private String name;
    private DatabaseService databaseService;

    public Student(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void createStudent(){
        //databaseService.getConnection();
        System.out.println("Create student "+getName());
        //databaseService.closDatabaseConnection();
    }
    public void getStudent(){
        System.out.println("Read student detail "+getName());
    }
    public Student deleteStudent(){
        System.out.println("Delete the student "+getName());
        return null;
    }
    public void updateStudent(){
        System.out.println("Update student "+getName());
    }
}
