package com.AopDemo;

import org.springframework.stereotype.Component;

@Component
public class testMethodAOp {
    public void manyAspects(){
        System.out.println("真正执行的manyAspects，但居然要开启@EnableAspectJAutoProxy(proxyTargetClass =false)");
    }
}
