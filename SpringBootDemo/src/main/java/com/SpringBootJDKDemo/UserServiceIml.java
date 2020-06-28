package com.SpringBootJDKDemo;

import org.springframework.stereotype.Service;

@Service
public class UserServiceIml implements UserService {
    @Override
    public void server() {
        System.out.println("this is UserServiceIml");
    }
}
