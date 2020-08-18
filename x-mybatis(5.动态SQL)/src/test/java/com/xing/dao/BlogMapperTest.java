package com.xing.dao;

import com.xing.pojo.Blog;
import com.xing.utils.IDUtils;
import com.xing.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BlogMapperTest {
    @Test
    // 插入一个
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        for (int i = 0; i < 10; i++) {
            blogMapper.addBlog(new Blog(IDUtils.getId(), "标题8" + i, "作者6", new Date(), 888));

        }
        sqlSession.close();
    }


    @Test
    // 查询
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("author", "6");
        List<Blog> blogList = mapper.getBlogList(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    // 查询
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<>();
//        map.put("author","作者6");
//        map.put("title","作者6");
        List<Blog> blogList = mapper.getBlogListChoose(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    // 更新
    public void test4() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("title", "修改后的title2");
        map.put("author", "东野圭谷");
        map.put("id", "46b349efbdad437b950d3b384f5d8c80");
        int i = blogMapper.updateBlog(map);
        System.out.println(i);
        sqlSession.close();
    }

    @Test
    // 查询： 根据foreach
    public void test5() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
//        list.add(777);
//        list.add(888);
        map.put("views",list);
        List<Blog> blogListForeach = mapper.getBlogListForeach(map);
        for (Blog blog : blogListForeach) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
}
