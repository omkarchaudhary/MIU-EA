package com.miu.myfirstspringjms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverTwo {
    @JmsListener(destination = "${springjms.cs544Queue}")
    public void receive(String message){
        System.out.println("The receiver two has received message -> "+message);
    }
}
