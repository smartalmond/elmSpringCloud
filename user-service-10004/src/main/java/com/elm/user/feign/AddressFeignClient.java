package com.elm.user.feign;

import com.elm.user.domain.po.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "deliveryaddress-service", fallback = AddressFeignClientCallBack.class)
public interface AddressFeignClient {

    @GetMapping("/DeliveryAddressController/listDeliveryAddressByUserId")
    CommonResult<List> listDeliveryAddressByUserId(@RequestParam("userId") String userId);
}
