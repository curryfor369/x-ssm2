package com.xing.daoImpl;

import com.xing.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void getUser() {
        System.out.println("默认的用户");
    }
}
