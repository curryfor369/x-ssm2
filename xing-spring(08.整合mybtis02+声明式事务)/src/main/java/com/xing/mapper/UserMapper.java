package com.xing.mapper;

import com.xing.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> selectUsers();

    void addUser(User user);
    void delUser(@Param("id") int id);
}
