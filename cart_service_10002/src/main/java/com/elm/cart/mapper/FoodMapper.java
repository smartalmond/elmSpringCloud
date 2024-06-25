package com.elm.cart.mapper;

import com.elm.cart.pojo.Food;
import org.apache.ibatis.annotations.Select;

public interface FoodMapper {
    @Select("select * from food where foodId=#{foodId}")
    public Food getFoodById(Integer foodId);
}
