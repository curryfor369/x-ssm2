package com.xing.dao;

public class UserDaoImpl implements UserDao{

    @Override
    public void add() {
        System.out.println("add方法");
    }

    @Override
    public void del() {
        System.out.println("del方法");
    }

    @Override
    public void update() {
        System.out.println("update方法");
    }

    @Override
    public void query() {
        System.out.println("query方法");
    }
}
