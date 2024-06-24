package com.elm.food.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elm.food.pojo.Food;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FoodMapper extends BaseMapper<Food> {

}
