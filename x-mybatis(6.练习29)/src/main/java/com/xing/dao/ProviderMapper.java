package com.xing.dao;

import com.xing.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderMapper {
    //查找所有供应商
    public List<Provider> selectList();
    //根据条件查询所有订单进行分页显示
    public List<Provider> selectByCondition(@Param("proCode")String proCode, @Param("proName")String proName, @Param("pageNo")Integer pageNo, @Param("pageSize")Integer pageSize);
    //根据条件查询所有供应商数量
    public int selectCountByCondition(@Param("proCode")String proCode,@Param("proName")String proName);
    //添加供应商
    public int insert(Provider provider);
    //根据id查找供应商信息
    public Provider selectProviderById(@Param("id") Integer id);
    //修改供应商
    public int updateProvider(Provider provider);
    //删除供应商
    public int deleteProvider(@Param("id") Integer id);
}
