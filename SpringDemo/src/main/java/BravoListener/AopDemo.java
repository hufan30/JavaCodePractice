package BravoListener;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopDemo {

    @Pointcut("execution(* order(..))")
    private void poincutDemo(){}

    @Before("poincutDemo()")
    public void test(){
        System.out.println("Before AOP");
    }
}
