package com.elm.user.feign;

import com.elm.user.domain.po.CommonResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressFeignClientCallBack implements AddressFeignClient {
    @Override
    public CommonResult<List> listDeliveryAddressByUserId(String userId) {
        // 返回降级响应
        return new CommonResult<>(403, "feign触发了熔断降级", null);
    }
}
