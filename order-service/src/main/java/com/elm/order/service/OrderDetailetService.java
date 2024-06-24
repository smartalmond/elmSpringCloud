package com.elm.order.service;

import com.elm.order.pojo.OrderDetailet;

import java.util.List;

public interface OrderDetailetService {
    int saveOrderDetailetBatch(List<OrderDetailet> list);
    List<OrderDetailet> listOrderDetailetByOrderId(Integer orderId);
}
