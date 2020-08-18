package com.xing.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
   static SqlSessionFactory sqlSessionFactory = null;

    static {
        try {
            String configPath = "mybatis-config.xml";
            InputStream ins = Resources.getResourceAsStream(configPath);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(ins);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true);
    }
}
