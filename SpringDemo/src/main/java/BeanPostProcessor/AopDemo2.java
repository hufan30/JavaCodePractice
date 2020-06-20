package BeanPostProcessor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class AopDemo2 {

    @Before("execution(* add(..))")
    public void test(){
        System.out.println("aop before");
    }

    @Test
    public void proxy(){
        Calculator cal = new CalCulatorImpl();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(cal);
        factory.addAspect(AopDemo2.class);
        Calculator proxy = factory.getProxy();
        proxy.add(1,2);
    }
}
