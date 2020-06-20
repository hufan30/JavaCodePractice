package com.AopDemo;

import org.springframework.stereotype.Component;

@Component
public class testMethodAOp {
    public void manyAspects(){
        System.out.println("真正执行的manyAspects，测试test类中需要开启@EnableAspectJAutoProxy(proxyTargetClass =false)");
    }
}
