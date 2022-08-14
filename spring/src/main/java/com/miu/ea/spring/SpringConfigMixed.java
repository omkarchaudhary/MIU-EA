package com.miu.ea.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:applicationContext_part1.xml")
public class SpringConfigMixed {
//    @Bean(value = "game2")
//    public Game getGameBean(Vehicle car){
//        Game car1 = new Game(car);
//        car1.setBrand("BMW");
//        return  car1;
//    }
}
