package com.miu.ea.cs544.exam3.jms;

import org.springframework.stereotype.Component;

@Component
public class Receiver {
    public void receive(String message){
        System.out.println("The received message from driver -> "+ message);
    }
}
