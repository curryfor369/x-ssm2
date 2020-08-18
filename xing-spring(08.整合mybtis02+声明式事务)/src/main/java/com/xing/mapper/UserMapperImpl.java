package com.xing.mapper;

import com.xing.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper{

    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> selectUsers() {
        addUser(new User(1,"123",123));
        delUser(12);
        return sqlSession.getMapper(UserMapper.class).selectUsers();
    }

    @Override
    public void addUser(User user) {
         sqlSession.getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public void delUser(int id) {
        sqlSession.getMapper(UserMapper.class).delUser(id);
    }
}
