package com.ynu.elm.controller;

import com.elm.common.utils.UserContext;
import com.ynu.elm.po.CommonResult;
import com.ynu.elm.po.DeliveryAddress;
import com.ynu.elm.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DeliveryAddressController")
public class DeliveryAddressController {

    @Autowired
    private DeliveryAddressService deliveryAddressService;

    @GetMapping("/listDeliveryAddressByUserId")
    public CommonResult<List<DeliveryAddress>> listDeliveryAddressByUserId() throws Exception{
        String userId = UserContext.getUser();
        List<DeliveryAddress> deliveryAddressList = deliveryAddressService.listDeliveryAddressByUserId(userId);
        return new CommonResult<>(200, "success", deliveryAddressList);
    }

    @GetMapping("/getDeliveryAddressById")
    public CommonResult<DeliveryAddress> getDeliveryAddressById(
            @RequestParam("daId") Integer daId) throws Exception{
        DeliveryAddress deliveryAddress = deliveryAddressService.getDeliveryAddressById(daId);
        return new CommonResult<>(200,"success", deliveryAddress);
    }

    @PostMapping("/saveDeliveryAddress")
    public CommonResult<Integer> saveDeliveryAddress(
            @RequestParam("contactName") String contactName,
            @RequestParam("contactSex") Integer contactSex,
            @RequestParam("contactTel") String contactTel,
            @RequestParam("address") String address) throws Exception {
        DeliveryAddress param = new DeliveryAddress();
        param.setContactName(contactName);
        param.setContactSex(contactSex);
        param.setContactTel(contactTel);
        param.setAddress(address);
        String userId = UserContext.getUser();
        param.setUserId(userId);
        int result = deliveryAddressService.saveDeliveryAddress(param);
        return new CommonResult<>(200, "success", result);
    }

    @PutMapping("/updateDeliveryAddress")
    public CommonResult<Integer> updateDeliveryAddress(
            @RequestParam("daId") Integer daId,
            @RequestParam("contactName") String contactName,
            @RequestParam("contactSex") Integer contactSex,
            @RequestParam("contactTel") String contactTel,
            @RequestParam("address") String address) throws Exception {
        DeliveryAddress param = new DeliveryAddress();
        param.setDaId(daId);
        param.setContactName(contactName);
        param.setContactSex(contactSex);
        param.setContactTel(contactTel);
        param.setAddress(address);
        int result = deliveryAddressService.updateDeliveryAddress(param);
        return new CommonResult<>(200,"success",result);
    }

    @DeleteMapping("/removeDeliveryAddress")
    public CommonResult<Integer> removeDeliveryAddress(@RequestParam("daId") Integer daId) throws Exception {
        int result = deliveryAddressService.removeDeliveryAddress(daId);
        return new CommonResult<>(200, "success", result);
    }

}
