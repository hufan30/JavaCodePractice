package com.AopDemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = testAop.class)
@SpringBootTest
@EnableAspectJAutoProxy(proxyTargetClass =false)
public class testMethodAOpTest {

    @Autowired
    private testMethodAOp t;

    /**
     * 这里真的出现了，@Test用的是junit4的注解，导致启动失败
     */
    @Test
    public void manyTest(){
        t.manyAspects();
    }
}