package com.example.springdatademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource({"file:/var/local/application.properties"})
public class SpringDataDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataDemoApplication.class, args);
    }

}
