package com.xing.dao;

import com.xing.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    // 添加一个
    int addBlog(Blog blog);

    // 查询
    List<Blog> getBlogList(Map<String,Object> map);
    List<Blog> getBlogListChoose(Map<String,Object> map);

    // 更新
    int updateBlog(Map<String,Object> map);

    // 查 通过 views
    List<Blog> getBlogListForeach(Map map);
}
