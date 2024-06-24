package com.elm.food.controller;

import com.elm.food.pojo.Food;
import com.elm.food.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/FoodController")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @RequestMapping("/listFoodByBusinessId")
    public List<Food> listFoodByBusinessId(Food food){
        return foodService.listFoodByBusinessId(food.getBusinessId());
    }

    @RequestMapping("/getFoodById")
    public Food getFoodById(Food food){
        return foodService.getFoodById(food.getFoodId());
    }
}
