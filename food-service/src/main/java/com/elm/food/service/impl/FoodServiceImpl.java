package com.elm.food.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.elm.food.mapper.FoodMapper;
import com.elm.food.pojo.Food;
import com.elm.food.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodMapper foodMapper;

    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        QueryWrapper<Food> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("business_id", businessId);
        return foodMapper.selectList(queryWrapper);
    }

    @Override
    public Food getFoodById(Integer foodId) {
        return foodMapper.selectById(foodId);
    }
}
