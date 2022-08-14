package com.miu.ea.springprofile;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class StudentAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Starting from class : " +
                target.getClass().getSimpleName() + "  and Method : " +
                method.getName());
    }
}
