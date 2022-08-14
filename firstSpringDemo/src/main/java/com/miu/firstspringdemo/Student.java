package com.miu.firstspringdemo;

public class Student {
    private String name;
    private int gpa;


    public Student() {
    }

    public Student(String name, int gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getGpa() {
        return gpa;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }

}
