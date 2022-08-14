package edu.miu.ea.springpractice.aspect;

import edu.miu.ea.springpractice.service.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJLogging {

    Logger logger;

    public AspectJLogging(Logger logger){
        this.logger = logger;
    }

    @Pointcut("execution(* edu.miu.ea.springpractice.service.EmailSystem.connectToMailServer(..))")
    public void emailConnectionEstablished(){
    }

    @Pointcut("execution(* edu.miu.ea.springpractice.service.EmailSystem.sendEmail(..))")
    public void emailSend(){
    }

    @Pointcut("execution(* edu.miu.ea.springpractice.service.StudentCRUD.create(..))")
    public void studentCreate(){
    }

    @Pointcut("execution(* edu.miu.ea.springpractice.service.StudentCRUD.delete(..))")
    public void studentDelete(){
    }


    @After("emailConnectionEstablished() || studentDelete() || studentCreate()")
    public void after(JoinPoint joinPoint) throws Throwable {
        logger.log("After "+joinPoint.getSignature().getDeclaringTypeName()+"-"+joinPoint.getSignature().getName());
    }

    @Before("emailSend()")
    public void before(JoinPoint joinPoint) throws Throwable {
        logger.log("Before "+joinPoint.getSignature().getDeclaringTypeName()+"-"+joinPoint.getSignature().getName());
    }
}
