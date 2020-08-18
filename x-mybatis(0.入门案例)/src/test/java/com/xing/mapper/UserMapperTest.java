package com.xing.mapper;

import com.xing.pojo.User;
import com.xing.utils.MybaitsUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    // 查所有
    public void test() {
        SqlSession sqlsession = MybaitsUtils.getSqlsession();
        try {
            UserMapper mapper = sqlsession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }
    }

    // 根据id 查一个
    @Test
    public void test2() {
        SqlSession sqlsession = MybaitsUtils.getSqlsession();
        UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
        User user = userMapper.getOneById(2);
        System.out.println(user);
        sqlsession.close();
    }

    // 增加一个
    @Test
    public void test3() {
        SqlSession sqlsession = MybaitsUtils.getSqlsession();
        UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
        int rows = userMapper.insertOne(new User(0, "王李四", 12));
        System.out.println(rows);
        sqlsession.commit();
        sqlsession.close();
    }

    // 删除一个
    @Test
    public void test4() {
        SqlSession sqlsession = MybaitsUtils.getSqlsession();
        UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
        int i = userMapper.deleteById(2);
        System.out.println(i);
        sqlsession.commit();
        sqlsession.close();
    }

    // 修改一个
    @Test
    public void test5() {
        SqlSession sqlsession = MybaitsUtils.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User user = new User(3, "修后", 88);
        System.out.println(user);
        int rows = mapper.updateById(user);
        System.out.println(rows);
        sqlsession.commit();
        sqlsession.close();
    }

    // 增加一个 通过万能map
    @Test
    public  void test6(){
        SqlSession sqlsession = MybaitsUtils.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","mapmap");
        map.put("userage",00);
        int i = mapper.insertByMap(map);
        System.out.println(i);
        sqlsession.commit();
        sqlsession.close();
    }

    // 模糊查询
    @Test
    public void test7() {
        SqlSession sqlsession = MybaitsUtils.getSqlsession();
        UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
        List<User> list = userMapper.getUserListWith("李");
        for (User user : list) {
            System.out.println(user);
        }
        sqlsession.close();
    }
}
