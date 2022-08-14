package com.miu.ea.lab5.entity;

import javax.persistence.*;
import java.util.List;

@Entity
//@EntityListeners({Callback.class})
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "student")
    private List<Course> course;

    public Student(){}

    public Student(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

//    @PostRemove
//    public void callBackWhenRemoved(){
//        System.out.println("Removed Student ");
//    }

//    @PostPersist
//    public void callBackWhenUpdated2(){
//        System.out.println("Persisted Student in different entity "+ this);
//    }

}
