package com.elm.order.feign;

import com.elm.order.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(name="cart-service-10002")
public interface CartFeignClient {
    @GetMapping("/CartController/listCart2")
    @ResponseBody
    CommonResult<List> listCarts(@RequestParam("userId") String userId, @RequestParam("businessId") Integer businessId);

    @DeleteMapping("CartController/removeCart")
    CommonResult<Integer> removeCart(@RequestParam("userId") String userId,
                                      @RequestParam("businessId") Integer businessId,
                                     @RequestParam(value = "foodId", required = false, defaultValue = "null") Integer foodId);

}
