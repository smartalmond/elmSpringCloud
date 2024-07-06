package com.elm.food.controller;

import com.elm.business.po.CommonResult;
import com.elm.food.pojo.Food;
import com.elm.food.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/FoodController")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping(value = "/listFoodByBusinessId", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult<List> listFoodByBusinessId(@RequestParam("businessId") Integer businessId) throws Exception {
        List<Food> list = foodService.listFoodByBusinessId(businessId);
        System.out.println(list);
        return new CommonResult(200, "success(200)", list);
    }

    @RequestMapping("/getFoodById")
    public Food getFoodById(Integer foodId){
        return foodService.getFoodById(foodId);
    }
}
