package com.xing.daoImpl;

import com.xing.dao.UserDao;

public class UserDaoMySqlImpl implements UserDao {

    @Override
    public void getUser() {
        System.out.println("mysql");
    }
}
