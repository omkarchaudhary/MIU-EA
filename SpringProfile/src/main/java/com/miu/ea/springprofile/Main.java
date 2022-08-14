package com.miu.ea.springprofile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program start");
        //byXmlConfigMethod();
        byJavaConfigMethod();
        System.out.println("Program end");
    }

    public static void byXmlConfigMethod(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = applicationContext.getBean("proxy",Student.class);
        student.deleteStudent();
    }
    public static void byJavaConfigMethod(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        context.getEnvironment().setActiveProfiles("prod");
//        context.register(SpringConfig.class);
//        context.refresh();
       // Student student = context.getBean("proxy",Student.class);
        Student student = context.getBean("student",Student.class);
        student.deleteStudent();
    }
}
