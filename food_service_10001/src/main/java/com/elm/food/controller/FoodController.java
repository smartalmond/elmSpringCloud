package com.elm.food.controller;

import com.elm.business.po.CommonResult;
import com.elm.food.pojo.Food;
import com.elm.food.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/FoodController")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping(value = "/listFoodByBusinessId/{businessId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult<List> listFoodByBusinessId(@PathVariable("businessId") Integer businessId) throws Exception {
        List<Food> list = foodService.listFoodByBusinessId(businessId);
        System.out.println(list);
        return new CommonResult(200, "success(10001)", list);
    }
    @RequestMapping("/getFoodById")
    public Food getFoodById(Food food){
        return foodService.getFoodById(food.getFoodId());
    }
}
