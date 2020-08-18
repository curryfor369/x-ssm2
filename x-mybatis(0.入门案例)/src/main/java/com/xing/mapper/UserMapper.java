package com.xing.mapper;

import com.xing.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 获取所有用户
    List<User> getUserList();

    // 查询一个 根据id
    User getOneById(int id);

    // 增加一个
    int insertOne(User user);

    // 删除一个 根据id
    int deleteById(int id);

    // 修改一个 根据id
    int updateById(User user);

    // 增加一个 万能map
    int insertByMap(Map<String,Object> map);

    // 模糊查询
    List<User> getUserListWith(String name);
}
