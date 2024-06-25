package com.elm.business.feign;

import com.elm.business.po.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "food-server", fallback = FoodFeignClientCallBack.class)
public interface FoodFeignClient {

    @GetMapping("/FoodController/listFoodByBusinessId/{businessId}")
    public CommonResult<List> listFoodByBusinessId(@PathVariable("businessId") Integer businessId);
}
