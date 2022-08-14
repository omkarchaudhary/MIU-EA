package com.miu.springdatajpademo.entities;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Student.findStudentGreatGPNamed", query = "SELECT s FROM Student s WHERE s.gpa > 30")
public class Student {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int gpa;

    public Student() {
    }

    public Student(String name, int gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
