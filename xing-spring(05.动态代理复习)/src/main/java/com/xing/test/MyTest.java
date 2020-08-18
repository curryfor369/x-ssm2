package com.xing.test;

import com.xing.dao.UserDao;
import com.xing.dao.UserDaoImpl;

public class MyTest {
    public static void main(String[] args) {
        MyProxy myProxy = new MyProxy();
        myProxy.setTarget(new UserDaoImpl());
        // 获取代理类
        UserDao proxy = (UserDao) myProxy.getProxy();
        //
        proxy.add();
    }
}
