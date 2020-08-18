package com.xing.dao;

import com.xing.pojo.Provider;
import com.xing.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ProviderMapperTest {
    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper providerMapper = sqlSession.getMapper(ProviderMapper.class);
        //查找所有供应商
        List<Provider> providers = providerMapper.selectList();
        for (Provider provider : providers) {
            System.out.println(provider);
        }

        sqlSession.close();
    }

    @Test
//    根据条件查询所有订单进行分页显示 selectByCondition
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper providerMapper = sqlSession.getMapper(ProviderMapper.class);
        //查找所有供应商
        new HashMap<String, Object>();
        List<Provider> providers = providerMapper.selectByCondition("", "", (1 - 1) * 2, 2);

        for (Provider provider : providers) {
            System.out.println(provider);
        }

        sqlSession.close();
    }

    @Test
//    根据条件查询个数
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper providerMapper = sqlSession.getMapper(ProviderMapper.class);
        int i = providerMapper.selectCountByCondition("GZ_GYS002", "兴化佳美调味品厂");
        System.out.println(i);

        sqlSession.close();
    }

    @Test
//    添加一个供应商
    public void test4() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper providerMapper = sqlSession.getMapper(ProviderMapper.class);
        Provider provider = new Provider();
        provider.setCreationDate(new Date());
        provider.setProCode("NBA_001");
        provider.setProName("金州勇士");
        int i = providerMapper.insert(provider);
        System.out.println(i);

        sqlSession.close();
    }

    @Test
//    修改一个供应商
    public void test5() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper providerMapper = sqlSession.getMapper(ProviderMapper.class);
        Provider provider = new Provider();
        provider.setId(19);
        provider.setCreationDate(new Date());
        provider.setProCode("1");
        provider.setProName("1");
        provider.setProDesc("1");
        provider.setProContact("1");
        provider.setProPhone("1");
        provider.setProAddress("1");
        provider.setProFax("1");
        provider.setModifyBy(1);
        provider.setModifyDate(new Date());
        int i = providerMapper.updateProvider(provider);
        System.out.println(i);

        sqlSession.close();
    }
    @Test
//    删除一个供应商
    public void test6() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper providerMapper = sqlSession.getMapper(ProviderMapper.class);
        int i = providerMapper.deleteProvider(19);
        System.out.println(i);
        sqlSession.close();
    }
}
