package com;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {

    /**
     * 这里主要是为了测试@RunWith和@SpringBootTest的配合
     * 首先在使用Junit4的@Test
     * 发现只注释@SpringBootTest没反应
     * 只注释@RunWith(SpringRunner.class)也只是启动容器环境，没有Spring的图标启动
     * 只有二者配合，才全部启动
     *
     * 然后使用Junit5的@Test
     * 因为在spring2.1.0版本后@SpringBootTest的注解中集成了@ExtendWith(SpringExtension.class)
     * 所以只需要一个@SpringBootTest，就可以启动环境了
     */
//    @Test
    @Test
    public void test(){
        System.out.println("junit4，test");
    }
}
