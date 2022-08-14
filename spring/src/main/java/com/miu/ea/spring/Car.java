package com.miu.ea.spring;

public class Car implements  Vehicle{

    private String carName;

    public Car() {
    }

    public Car(String carName) {
        this.carName = carName;
    }

    @Override
    public void  move(){
        System.out.println(" Car is Moving at 50 ");
    }

    public void destroy(){
        System.out.println("The car has been destroyed");
    }
}
