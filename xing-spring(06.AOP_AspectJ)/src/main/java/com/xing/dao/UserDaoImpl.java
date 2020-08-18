package com.xing.dao;

public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("add了一个用户");
    }

    @Override
    public void del() {
        System.out.println("del了一个用户");

    }

    @Override
    public void update() {
        System.out.println("update了一个用户");

    }

    @Override
    public void query() {
        System.out.println("query了一个用户");

    }
}
