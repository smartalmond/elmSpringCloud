package com.elm.business.mapper;

import com.elm.business.po.Business;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

@Mapper
public interface BusinessMapper{

    //使用注解+xml结合的方式，简单的查询用注解，复杂查询、更新、插入操作写在xml映射文件中

    @Select("select * from business where orderTypeId=#{orderTypeId} order by businessId")
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);

    @Select("select * from business where businessId=#{businessId}")
    public Business getBusinessById(Integer businessId);

    @Select("select * from business limit #{num}")
    public List<Business> listBusinessByNum(Integer num);

}