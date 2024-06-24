package com.elm.food.service;

import com.elm.food.pojo.Food;

import java.util.List;

public interface FoodService {
    List<Food> listFoodByBusinessId(Integer businessId);
    Food getFoodById(Integer foodId);
}
