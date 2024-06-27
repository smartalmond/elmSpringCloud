package com.elm.food.mapper;

import com.elm.food.pojo.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface FoodMapper {

    @Select("select * from food where businessId=#{businessId}")
    public List<Food> listFoodByBusinessId(Integer businessId);

    @Select("select * from food where foodId=#{foodId}")
    public Food getFoodById(Integer foodId);

}
