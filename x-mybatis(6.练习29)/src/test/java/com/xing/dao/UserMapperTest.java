package com.xing.dao;

import com.xing.pojo.User;
import com.xing.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class UserMapperTest {
    //    查询单个用户
    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User adminn = userMapper.selectByCodeAndPassword("admin", "123123");
        System.out.println(adminn);
        sqlSession.close();
    }

    //    根据条件查询所有用户进行分页显示
    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Integer pageNo = 2;
        Integer pageSize = 5;

        List<User> users = userMapper.selectByCondition("张", 3, (pageNo - 1) * pageSize, 5);
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    //    根据条件查询用户总数量
    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int i = userMapper.selectCountByCondition("", null);
        System.out.println(i);
        sqlSession.close();
    }

    // 添加用户
    @Test
    public void test4() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(66);
        user.setUserCode("code123");
        user.setUserName("name123");
        user.setUserPassword("pwd123");
        user.setBirthday(new Date());

        int insert = userMapper.insert(user);
        System.out.println(insert);
        sqlSession.close();
    }

    // 修改密码
    @Test
    public void test6() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updatePwd("666666",66);
        sqlSession.close();
    }


    // 删除
    @Test
    public void test5() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.deleteUser(66));

        sqlSession.close();
    }
}
