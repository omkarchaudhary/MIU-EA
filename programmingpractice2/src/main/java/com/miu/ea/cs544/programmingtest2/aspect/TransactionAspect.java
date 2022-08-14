package com.miu.ea.cs544.programmingtest2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TransactionAspect {
    @Before("execution(* com.miu.ea.cs544.programmingtest2.service.StudentCRUD.*())")
    public void transactionStarted(JoinPoint joinPoint){
        System.out.println("Transaction started");
    }
    @After("execution(* com.miu.ea.cs544.programmingtest2.service.StudentCRUD.*())")
    public void transactionCommited(JoinPoint joinPoint){
        System.out.println("Transaction committed");
    }

}
