package com.hcsp.apo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: HuFan
 * @time: 2020/3/258:50 下午
 **/
@RestController
@RequestMapping("/aopController")
public class AopController {

    @RequestMapping("/Curry")
    public void Curry() {
        System.out.println("库里上场打球了！！");
    }
}
