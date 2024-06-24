package com.elm.user.controller;

import com.elm.user.pojo.DeliveryAddress;
import com.elm.user.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/DeliveryAddressController")
public class DeliveryAddressController {
    @Autowired
    private DeliveryAddressService deliveryAddressService;

    @RequestMapping("/listDeliveryAddressByUserId")
    public List<DeliveryAddress> listDeliveryAddressByUserId(DeliveryAddress deliveryAddress){
        return deliveryAddressService.listDeliveryAddressByUserId(deliveryAddress.getUserId());
    }

    @RequestMapping("/getDeliveryAddressById")
    public DeliveryAddress getDeliveryAddressById(DeliveryAddress deliveryAddress){
        return deliveryAddressService.getDeliveryAddressById(deliveryAddress.getDaId());
    }

    @RequestMapping("/saveDeliveryAddress")
    public int saveDeliveryAddress(DeliveryAddress deliveryAddress){
        return deliveryAddressService.saveDeliveryAddress(deliveryAddress);
    }

    @RequestMapping("/updateDeliveryAddress")
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress){
        return deliveryAddressService.updateDeliveryAddress(deliveryAddress);
    }

    @RequestMapping("/removeDeliveryAddress")
    public int removeDeliveryAddress(DeliveryAddress deliveryAddress){
        return deliveryAddressService.removeDeliveryAddress(deliveryAddress.getDaId());
    }
}
