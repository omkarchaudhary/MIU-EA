package com.miu.ea.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig {
//    @Bean
//    public Vehicle getCarBean(){
//        return new Car();
//    }

    @Bean(name = "bike")
    @Scope(value = "prototype")
    public Vehicle getBikeBean(){
        return new Bike();
    }

    @Bean
    public Game getGameBean() {
        Game game = new Game() {
            @Override
            public Vehicle getVehicle() {
                return getBikeBean();
            }
        };
        return game;
    }

//    @Bean
//    @Scope(value = "singleton")
//    public Game getGameBean(Vehicle getBikeBean){
//        return new Game(getBikeBean);
//    }
//    @Bean
//    public Game getGame1Bean(){
//        Game car1 = new Game(getCarBean());
//        car1.setBrand("BMW");
//        return  car1;
//    }
//    @Bean(name = "game1", initMethod = "initMethod", destroyMethod = "destroy")
//    public Game getGame1Bean(){
//        Game game1 = new Game(getCarBean());
//        game1.setBrand("BMW");
//        return  game1;
//    }
    @Bean
    public static PrototypeDestroy getPrototypeDestroyBean(BeanFactory beanFactory){
        PrototypeDestroy prototypeDestroy = new PrototypeDestroy();
        //prototypeDestroy.setBeanFactory(beanFactory);
        return prototypeDestroy;
    }

//    @Bean
//    public static MyBeanPostProcessor getMyBeanPostProcessor(){
//        return new MyBeanPostProcessor();
//    }
}
