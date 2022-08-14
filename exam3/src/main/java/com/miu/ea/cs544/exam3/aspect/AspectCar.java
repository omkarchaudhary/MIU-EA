package com.miu.ea.cs544.exam3.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectCar {

    @After("execution(* com.miu.ea.cs544.exam3.controller.CarController.deleteCar(..))")
    public void afterCarDelete(JoinPoint joinPoint){
        System.out.println("The car driver is updated "+joinPoint.getSignature().getName());
    }
}
