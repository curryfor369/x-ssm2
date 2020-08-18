package com.xing.service;

import com.xing.dao.UserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDaoImpl = (UserDao) context.getBean("userDao");
        userDaoImpl.add();
    }
}
