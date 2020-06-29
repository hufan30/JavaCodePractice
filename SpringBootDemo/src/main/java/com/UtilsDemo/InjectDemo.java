package com.UtilsDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author hufan
 * @date 2020/6/29 6:52 下午
 * @annotation
 */
@Component
public class InjectDemo {

    @Value("${testValue}")
    String testValue;

    public String sayHello(){
        return testValue;
    }

}
