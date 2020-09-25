package com.UtilsDemo;


import com.MainDemo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * @author hufan
 * @date 2020/6/29 6:44 下午
 * @annotation
 */
@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest(classes = MainDemo.class)
public class RefelctionDemoTest {

    @Spy
    InjectDemo injectDemo;

    @InjectMocks
    RefelctionDemo refelctionDemo;

    /**
     * 这里MockitoAnnotations.initMocks(this);
     * 和开头的@RunWith(MockitoJUnitRunner.class)；
     * 二选一，是的@Mock和@InjectMock生效
     */
    @Before
    public void before(){
//        MockitoAnnotations.initMocks(this);
        System.out.println("before");
    }

    @Test
    public void testAdd(){
        RefelctionDemo rf = new RefelctionDemo();
        Object add = ReflectionTestUtils.invokeMethod(rf, "add", 1,2);
    }

    @Test
    public void testInject(){
        Mockito.doReturn("Mock hello").when(injectDemo).sayHello();
        refelctionDemo.inject();
    }

}