package com.xing.dao;

import com.xing.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {   //查询单个用户
    public User selectByCodeAndPassword(@Param("userCode") String userCode, @Param("userPassword") String userPassword);

    //根据条件查询所有用户进行分页显示
    public List<User> selectByCondition(@Param("userName") String userName, @Param("userRole") Integer userRole, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

    //根据条件查询用户总数量
    public int selectCountByCondition(@Param("userName") String userName, @Param("userRole") Integer userRole);

    //添加用户
    public int insert(User user);

    //根据id查找用户信息
    public User selectUserById(@Param("id") Integer id);

    //修改用户
    public int updateUser(User user);

    //删除用户
    public int deleteUser(@Param("id") Integer id);

    //修改密码
    public int updatePwd(@Param("pwd") String pwd, @Param("id") Integer id);
}
