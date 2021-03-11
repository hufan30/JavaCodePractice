package com.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerDemo {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
