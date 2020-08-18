package com.xing.service;

import com.xing.mapper.UserMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserService {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapperImpl = (UserMapper) context.getBean("userMapperImpl");
        userMapperImpl.selectUsers().forEach(System.out::println);
    }
}
