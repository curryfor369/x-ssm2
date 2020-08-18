package com.xing.mapper;

import com.xing.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;
// SqlSessionDaoSupport 这个类可以帮我们生成SqlSession对象，通过getSession()获取
public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {


    @Override
    public List<User> selectUser() {
        return getSqlSession().getMapper(UserMapper.class).selectUser();
    }
}
