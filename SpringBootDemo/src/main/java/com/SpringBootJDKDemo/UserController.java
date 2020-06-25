package com.SpringBootJDKDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getUserService")
    public void getUserService(){
        System.out.println("this is UserController");
        userService.server();
        System.out.println(userService.getClass().getName());
    }
}
