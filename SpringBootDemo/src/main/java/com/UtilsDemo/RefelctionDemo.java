package com.UtilsDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author hufan
 * @date 2020/6/29 6:43 下午
 * @annotation
 */
@Component
public class RefelctionDemo {

    @Autowired
    private InjectDemo injectDemo;

    public void add(int a,int b){
        System.out.println(a+b);
    }
    public void add(){
        System.out.println("add");
    }

    public void inject(){
        System.out.println(injectDemo.sayHello());
    }
}
