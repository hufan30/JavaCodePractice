package BeanPostProcessor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class testAop {

    @Before("execution(* manyAspects(..))")
    public void test(){

    }
}
