package com.SpringMVCBootDemo.Controller;

import com.SpringMVCBootDemo.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.*;
import java.util.List;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/3/2710:44 上午
 **/
@org.springframework.stereotype.Controller
@RequestMapping("/demo")
public class Controller {
    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @RequestMapping("/hello")
    public void hello(@RequestBody List<String> param) {
        service.sayHello();
    }

    @RequestMapping("/hello2")
    public void hello2(@myRequestBody List<String> param) {
        service.sayHello();
    }

    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface myRequestBody {
    }

}




