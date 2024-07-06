package com.elm.cart.mapper;

import com.elm.cart.domain.pojo.Business;
import org.apache.ibatis.annotations.Select;

public interface BusinessMapper {
    @Select("select * from business where businessId=#{businessId}")
    public Business getBusinessById(Integer businessId);
}
