package com.miu.ea.cs544.exam3.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Driver extends Person{
    @ManyToOne
    private Owner owner;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "owner=" + owner +
                '}';
    }
}
