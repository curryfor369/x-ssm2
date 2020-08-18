package com.xing.mapper;

import com.xing.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 查询一个 根据id
    User getOneById(int id);

    // 分页查询 使用万能map
    List<User> getUsersByLimit(Map<String,Integer> map);
}
