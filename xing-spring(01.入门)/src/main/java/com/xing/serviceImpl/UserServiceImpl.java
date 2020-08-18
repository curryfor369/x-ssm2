package com.xing.serviceImpl;

import com.xing.dao.UserDao;

public class UserServiceImpl {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    // 查询默认用户
    public void getUser() {
        userDao.getUser();
    }
}
