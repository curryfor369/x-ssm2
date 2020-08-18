package com.xing.dao;

import com.xing.pojo.Student;

import java.util.List;

public interface StudentMapper {

    // 查所有学生
    List<Student> getStudentList();
}
