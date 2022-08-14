package com.miu.myfirstspringjms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    @JmsListener(destination = "${springjms.cs544Queue}")
    public void receive(String message){
        System.out.println("The receiver has received message -> "+message);
    }
}
