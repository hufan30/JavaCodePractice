package com.SpringMVCBootDemo.Service;

import com.AopDemo.testMethodAOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/3/2710:43 上午
 **/
@RestController
public class Service {

//    @Autowired
//    testMethodAOp t;

    public void sayHello() {
        System.out.println("hello");
    }

//    @RequestMapping("/testAop")
//    public void testAop() {
//        t.manyAspects();
//    }
}
