package com.elm.user.service;

import com.elm.user.pojo.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressService {
    List<DeliveryAddress> listDeliveryAddressByUserId(String userId);
    DeliveryAddress getDeliveryAddressById(Integer daId);
    int saveDeliveryAddress(DeliveryAddress deliveryAddress);
    int updateDeliveryAddress(DeliveryAddress deliveryAddress);
    int removeDeliveryAddress(Integer daId);
}
