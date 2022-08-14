package com.ea.exam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Bank extends Owner{
    @OneToOne
    private Address bankAddress;

    public Address getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(Address bankAddress) {
        this.bankAddress = bankAddress;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankAddress=" + bankAddress +
                '}';
    }
}
