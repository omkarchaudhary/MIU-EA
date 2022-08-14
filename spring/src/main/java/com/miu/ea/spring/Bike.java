package com.miu.ea.spring;

public class Bike implements Vehicle {
    @Override
    public void move(){
        System.out.println("Bike is moving at 15 ");
    }

    public void destroy(){
        System.out.println("The bike has destroyed");
    }
}
