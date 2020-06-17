package com;

import com.AopDemo.testMethodAOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainDemo {

    // 启动切面
    public static void main(String[] args) {
        SpringApplication.run(MainDemo.class, args);
//        t.manyAspects();
    }
}
