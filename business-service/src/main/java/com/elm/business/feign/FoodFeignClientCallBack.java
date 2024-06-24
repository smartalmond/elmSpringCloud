package com.ynu.elm.feign;

import com.ynu.elm.po.CommonResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FoodFeignClientCallBack implements FoodFeignClient{
    @Override
    public CommonResult<List> listFoodByBusinessId(Integer businessId) {
        // 返回降级响应
        return new CommonResult<>(403, "feign触发了熔断降级", null);
    }
}
