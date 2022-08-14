package com.miu.ea.cs544.programmingtest2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;

@Aspect
public class LoggingAspect {

    @After("execution(* com.miu.ea.cs544.programmingtest2.service.EmailSystem.connectToMailServer())")
    public void mailServerConnected(JoinPoint joinPoint){
        System.out.println("Mail server connected ");
    }
    @Before("execution(* com.miu.ea.cs544.programmingtest2.service.EmailSystem.sendEmail())")
    public void mailSent(JoinPoint joinPoint){
        System.out.println("Mail sent");
    }
    @After("execution(* com.miu.ea.cs544.programmingtest2.service.StudentCRUD.create())")
    public void logAfterStudentCreate(JoinPoint joinPoint){
        System.out.println("Mail server connected ");
    }
    @After("execution(* com.miu.ea.cs544.programmingtest2.service.StudentCRUD.delete())")
    public void logAfterStudentDelete(JoinPoint joinPoint){
        System.out.println("Mail server connected ");
    }

}
