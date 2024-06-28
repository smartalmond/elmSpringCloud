package com.elm.order.feign;

import com.elm.order.pojo.CommonResult;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class CartFeignClientCallBack implements CartFeignClient{
    @Override
    public CommonResult<List> listCarts(@RequestParam("userId") String userId, @RequestParam("businessId") Integer businessId) {
        // 返回降级响应
        return new CommonResult<>(403, "feign触发了熔断降级", null);
    }

    @Override
    public CommonResult<Integer> removeCart(@RequestParam("userId") String userId,
                                     @RequestParam("businessId") Integer businessId,
                                     @RequestParam(value = "foodId", required = false, defaultValue = "null") Integer foodId){
        // 返回降级响应
        return new CommonResult<>(403, "feign触发了熔断降级", null);
    }

}
