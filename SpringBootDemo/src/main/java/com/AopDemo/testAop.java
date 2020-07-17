package com.AopDemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@Configuration
@ComponentScan("com.AopDemo")
/**
 * 这里的ComponectScan是为了test类用的，在启动类启动后，无需这行注释；
 */
//@EnableAspectJAutoProxy(proxyTargetClass =false)
public class testAop {

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
    @Test
    public void test2(){

    }
}
