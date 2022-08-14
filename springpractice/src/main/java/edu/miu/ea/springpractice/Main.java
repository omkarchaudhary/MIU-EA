package edu.miu.ea.springpractice;

import edu.miu.ea.springpractice.service.EmailSystem;
import edu.miu.ea.springpractice.service.StudentCRUD;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        GenericXmlApplicationContext springContext = new GenericXmlApplicationContext();
//        springContext.load("config.xml");
//        springContext.refresh();

        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext();
        springContext.scan("edu.miu.ea.springpractice.config");
        springContext.refresh();

        EmailSystem emailSystem = springContext.getBean(EmailSystem.class);
        emailSystem.connectToMailServer();
        emailSystem.sendEmail();
        StudentCRUD studentCRUD = springContext.getBean(StudentCRUD.class);
        studentCRUD.create();
        studentCRUD.read();
        studentCRUD.update();
        studentCRUD.delete();

    }
}
