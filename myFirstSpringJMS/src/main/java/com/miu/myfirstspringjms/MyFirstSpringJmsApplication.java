package com.miu.myfirstspringjms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class MyFirstSpringJmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstSpringJmsApplication.class, args);
    }

}
