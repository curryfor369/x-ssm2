package com.xing.mapper;


import com.xing.pojo.User;
import com.xing.utils.MybaitsUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


public class UserMapperTest {

    // 日志对象
    static  Logger logger = Logger.getLogger(UserMapperTest.class);


    // 结果集映射 ResultMap
    @Test
    public void test1(){
        SqlSession sqlsession = MybaitsUtils.getSqlsession();
        UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
        User user = userMapper.getOneById(1);
        System.out.println(user);
        sqlsession.close();
    }

    // 输出日志
    @Test
    public void test2(){
        logger.info("hello?????????????/");
    }

    // 分页查询
    @Test
    public void test3() {
        SqlSession sqlsession = MybaitsUtils.getSqlsession();
        UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex",1);
        map.put("pageSize",3);
        List<User> users = userMapper.getUsersByLimit(map);
        for (User user : users) {
            System.out.println(user);
        }
        sqlsession.close();
    }
}
