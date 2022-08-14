package com.miu.ea.cs544.programmingtest2;

import com.miu.ea.cs544.programmingtest2.config.SpringConfig;
import com.miu.ea.cs544.programmingtest2.service.EmailSystem;
import com.miu.ea.cs544.programmingtest2.service.StudentCRUD;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program start ..");

        byJavaConfigMethod();
        //byXMlConfigMethod();
        System.out.println("Program end ..");
    }

    private static void byXMlConfigMethod(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
//        context.getEnvironment().setActiveProfiles("dev");
//        context.refresh();
        // setting variable in IDE
        EmailSystem emailSystem = context.getBean(EmailSystem.class);
        emailSystem.connectToMailServer();
        emailSystem.sendEmail();

        StudentCRUD student = context.getBean(StudentCRUD.class);
        student.create();
        student.read();
        student.update();
        student.delete();
    }
    private static void byJavaConfigMethod() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(SpringConfig.class);
        context.refresh();
        EmailSystem emailSystem = context.getBean(EmailSystem.class);
        emailSystem.connectToMailServer();
        emailSystem.sendEmail();

        StudentCRUD student = context.getBean(StudentCRUD.class);
        student.create();
        student.read();
        student.update();
        student.delete();
    }
}
