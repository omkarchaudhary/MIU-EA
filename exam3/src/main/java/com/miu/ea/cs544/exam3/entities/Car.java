package com.miu.ea.cs544.exam3.entities;

import javax.persistence.*;

@Entity
public class Car {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int years;
    private double price;
    private int millage;
    @ManyToOne(cascade = CascadeType.ALL)
    private Owner carOwner;

    @OneToOne(cascade = CascadeType.ALL)
    private Driver driver;
    public Car() {
    }

    public Car(int years, double price, int millage, Owner carOwner, Driver driver) {
        this.years = years;
        this.price = price;
        this.millage = millage;
        this.carOwner = carOwner;
        this.driver = driver;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMillage() {
        return millage;
    }

    public void setMillage(int millage) {
        this.millage = millage;
    }

    public Owner getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(Owner carOwner) {
        this.carOwner = carOwner;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", years=" + years +
                ", price=" + price +
                ", millage=" + millage +
                '}';
    }
}
