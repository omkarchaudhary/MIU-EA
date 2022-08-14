package com.miu.ea.springprofile;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableAspectJAutoProxy
public class SpringConfig {
    @Bean
    //@Profile({"dev","default"})
    public DatabaseService databaseServiceBeanForDev(){
        DatabaseService databaseService = new DatabaseService();
        databaseService.setUrl("Development");
        return databaseService;
    }

    @Bean("student")
    //@Profile(value = "dev")
    public  Student studentBeanForDev(){
        Student student = new Student(databaseServiceBeanForDev());
        student.setName("Omkar");
        return student;
    }
    @Bean
    public EmailService emailServiceBean(){
        return  new EmailService();
    }
    @Bean
    public StudentAdvice studentAdviceBean(){
        return  new StudentAdvice();
    }
//    @Bean("proxy")
//    public ProxyFactoryBean proxyFactoryBean(){
//        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
//        String [] interceptors = {"studentAdviceBean"};
//        proxyFactoryBean.setTarget(studentBeanForDev());
//        proxyFactoryBean.setInterceptorNames(interceptors);
//        return proxyFactoryBean;
//    }
//    @Bean
//    @Profile(value = "prod")
//    public DatabaseService databaseServiceBeanForProd(){
//        DatabaseService databaseService = new DatabaseService();
//        databaseService.setUrl("Production");
//        return databaseService;
//    }
//
//    @Bean
//    @Profile(value = "prod")
//    public  Student studentBeanForProd(){
//        Student student = new Student(databaseServiceBeanForProd());
//        student.setName("Omkar");
//        return student;
//    }
}
