package com.miu.jobsearch.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingDeleteAspect {
    @Pointcut("execution(* com.miu.jobsearch.repository.ApplicationRepository.deleteById(..))")
    public void applicationDeleted() {
    }

    @Pointcut("execution(* com.miu.jobsearch.repository.CompanyRepository.deleteById(..))")
    public void companyDeleted() {
    }

    @Pointcut("execution(* com.miu.jobsearch.repository.InterviewRepository.deleteById(..))")
    public void interviewDeleted() {
    }

    @Pointcut("execution(* com.miu.jobsearch.repository.JobRepository.deleteById(..))")
    public void jobDeleted() {
    }

    @Pointcut("execution(* com.miu.jobsearch.repository.SkillRepository.deleteById(..))")
    public void skillDeleted() {
    }

    @After("applicationDeleted() || companyDeleted() || interviewDeleted() || jobDeleted() || skillDeleted()")
    public void afterDeletingApplication(JoinPoint joinPoint) {
        System.out.println("Object type of " + joinPoint.getSignature().getDeclaringTypeName() + " - using method "
                + joinPoint.getSignature().getName() + " with id " + joinPoint.getArgs()[0] +
                " deleted Successfully.");
    }
}
