package com.xing.dao;

import com.xing.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 根据id查询
    @Select("select * from user where id = #{uid}")
    User getUserById(@Param("uid") int id);

    // 查询全部
    @Select("select * from user")
    List<User> getUserList();

    // 增
    @Insert("insert into user(name,age) values(#{name},#{age})")
    int addUser(User user);

    @Insert("insert into user(name,age) values(#{name},#{age})")
    int addUser2(Map<String,Object> map);

    // 删
    @Delete("delete from user where id = #{id}")
    int deleteUserById(int id);

    // 改
    @Update("update user set name= #{uname},age=#{uage} where id = #{uid}")
    int updateUserById(Map<String,Object> map);
}
