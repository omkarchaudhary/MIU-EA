package com.miu.ea.cs544.exam3.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Owner extends Person{
    @OneToMany(mappedBy ="carOwner" )
    private List<Car> car;
    @OneToMany(mappedBy = "owner")
    private List<Driver> driver;
    @OneToOne
    private Address address;


    public List<Car> getCar() {
        return car;
    }

    public void setCar(List<Car> car) {
        this.car = car;
    }

    public List<Driver> getDriver() {
        return driver;
    }

    public void setDriver(List<Driver> driver) {
        this.driver = driver;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
