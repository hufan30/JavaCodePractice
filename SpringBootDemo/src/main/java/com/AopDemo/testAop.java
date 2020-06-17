package com.AopDemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@Configuration
@ComponentScan("com.AopDemo")
@EnableAspectJAutoProxy(proxyTargetClass =false)
public class testAop {

    @Autowired
    testMethodAOp t;

    @Before("execution(* manyAspects(..))")
    public void test(){
        System.out.println("hello this is before aop");
    }
    @Around("execution(* manyAspects(..))")
    public void testAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before around");
        joinPoint.proceed();
        System.out.println("after aroud");
    }
}
