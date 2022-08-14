package com.ea.exam.entity;

import jakarta.persistence.*;

@Entity
public class House {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int numberOfEmployee;
    private double cost;

    @ManyToOne
    private Owner houseOwner;

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

    public int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public void setNumberOfEmployee(int numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Owner getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(Owner houseOwner) {
        this.houseOwner = houseOwner;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfEmployee=" + numberOfEmployee +
                ", cost=" + cost +
                ", houseOwner=" + houseOwner +
                '}';
    }
}
