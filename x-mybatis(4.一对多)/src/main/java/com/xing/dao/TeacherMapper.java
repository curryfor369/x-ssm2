package com.xing.dao;

import com.xing.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    // 根据id查询一个老师的姓名和 所有学生
    Teacher getTeacherStus(@Param("tid") int id);
}
