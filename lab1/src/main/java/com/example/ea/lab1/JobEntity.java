package com.example.ea.lab1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JobEntity {
    @Id
    private Long id;
    private String title;
    private double salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
