package com.example.springdatademo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "Student.findFailing",query = "SELECT s FROM Student s where s.gpa<29")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer gpa;

    @ManyToOne(cascade = {CascadeType.PERSIST},fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany(mappedBy = "enrolStudents")
    private List<Course> enrolCourses;


    public Student() {
    }

    public Student(String name, Integer gpa, Address address) {
        this.name = name;
        this.gpa = gpa;
        this.address=address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGpa() {
        return gpa;
    }

    public void setGpa(Integer gpa) {
        this.gpa = gpa;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Course> getEnrolCourses() {
        return enrolCourses;
    }

    public void setEnrolCourses(List<Course> enrolCourses) {
        this.enrolCourses = enrolCourses;
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
