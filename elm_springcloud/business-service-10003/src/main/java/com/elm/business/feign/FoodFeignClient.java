package com.elm.business.feign;

import com.elm.business.po.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "food-service", fallback = FoodFeignClientCallBack.class)
public interface FoodFeignClient {

    @GetMapping("/FoodController/listFoodByBusinessId")
    CommonResult<List> listFoodByBusinessId(@RequestParam("businessId") Integer businessId);
}
