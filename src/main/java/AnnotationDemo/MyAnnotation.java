package AnnotationDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/2/1710:15 上午
 **/
public class MyAnnotation {



    @annotationDemo
    public void test(){
        int[] test = new int[3];
        int[] test2 = new int[]{1, 2, 3};
    }

}

//元注解，用来解释注解的，target是注解的域，retention是注解的运行范围；
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface annotationDemo{

}
