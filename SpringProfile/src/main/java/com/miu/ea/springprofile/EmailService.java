package com.miu.ea.springprofile;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class EmailService {
    @Before("execution(* com.miu.ea.springprofile.Student.*())")
    public void sendEmailBefore(JoinPoint joinPoint){
        System.out.println("The email is sending ");
        //System.out.println(joinPoint.getSignature().getName());
    }

    @After("execution(* com.miu.ea.springprofile.Student.*())")
    public void sendEmailAfter(JoinPoint joinPoint){
        System.out.println("The email is sent ");
        //System.out.println(joinPoint.getSignature().getName());
    }
    @Pointcut("execution(* com.miu.ea.springprofile.Student.*())")
    public void sendEmailAfterPointCut(){
        System.out.println("The email is sent ");
        //System.out.println(joinPoint.getSignature().getName());
    }
    @Pointcut("execution(* com.miu.ea.springprofile.Student.*())")
    public void sendEmailBeforePointCut(){
        System.out.println("The email is sending ");
        //System.out.println(joinPoint.getSignature().getName());
    }

    @After("sendEmailAfterPointCut() || sendEmailBeforePointCut()")
    public void afterAndBefore(JoinPoint joinPoint){
        System.out.println("The pointcut info. ");
    }

}
