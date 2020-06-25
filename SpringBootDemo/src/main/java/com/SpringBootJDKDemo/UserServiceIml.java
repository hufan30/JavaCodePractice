package com.SpringBootJDKDemo;

import ProxyDemo.MyTransactionDemo.Annotation.MyTransactional;
import org.springframework.stereotype.Service;

@Service
@MyTransactional
public class UserServiceIml implements UserService {
    @Override
    public void server() {
        System.out.println("this is UserServiceIml");
    }
}
