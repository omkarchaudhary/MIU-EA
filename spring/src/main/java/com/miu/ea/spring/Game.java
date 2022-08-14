package com.miu.ea.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//@Component
public abstract class Game implements  DisposableBean {
    private Vehicle vehicle;
    private  String brand;
//    private ApplicationContext applicationContext;
//    public Game(Vehicle vehicle) {
//        System.out.println("1. From Game class: Bean constructor called.");
//        this.vehicle = vehicle;
//    }

    public void initMethod(){
        System.out.println("4. From Game class: Initialization Method called");
    }
    public  void playGame(){
        getVehicle().move();
    }
    public void setBrand(String brand) {
        this.brand = brand;
        System.out.println("2. From Game class: Setter DI called.");
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public void destroy(){
        System.out.println("The Game has been destroyed");
    }

//    public Vehicle getVehicle() {
//        //return vehicle;
//        return new Bike(); // Tight couple
//        //return applicationContext.getBean(Bike.class); // couple with spring when we use ApplicationContextAware
//    }

    // DI Method
//    @Lookup
    public abstract Vehicle getVehicle();

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
}
