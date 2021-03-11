package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class MainDemo {

    /**
     * 这个main方法是废的，需要在com下面几层建立main才生效
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(MainDemo.class, args);
    }
}
