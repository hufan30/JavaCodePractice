package com.ConfigurationDemo;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hufan
 * @date 2020/7/5 4:29 下午
 * @annotation
 */
public class Teacher {

    Student s;

    public Teacher(Student s) {
        this.s = s;
        System.out.println(s.id);
    }

    public String getId(){
        return s.id;
    }
}
