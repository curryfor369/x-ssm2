package com.xing.test;

import com.xing.dao.UserMapper;
import com.xing.pojo.User;
import com.xing.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
    @Test
    // 查一个
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper us = sqlSession.getMapper(UserMapper.class);
        User user = us.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    // 查所有
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper us = sqlSession.getMapper(UserMapper.class);
        List<User> userList = us.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    // 增加一个
    public void test4() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper us = sqlSession.getMapper(UserMapper.class);
        int rows = us.addUser(new User(0, "新1", 11));
        System.out.println(rows);
        sqlSession.close();
    }

    @Test
    // 增加一个2
    public void test5() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper us = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "新2");
        map.put("age", 22);
        int i = us.addUser2(map);
        System.out.println(i);
        sqlSession.close();
    }

    @Test
    // 改
    public void test6() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper us = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", 1);
        map.put("uname", "1");
        map.put("uage", 1);
        us.updateUserById(map);
        sqlSession.close();
    }

    @Test
    // 删除
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper us = sqlSession.getMapper(UserMapper.class);
        int i = us.deleteUserById(3);
        System.out.println(i == 1 ? "删除成功" : "删除失败");
        sqlSession.close();
    }
}
