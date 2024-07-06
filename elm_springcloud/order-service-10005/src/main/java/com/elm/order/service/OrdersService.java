package com.elm.order.service;

import com.elm.order.pojo.Orders;

import java.util.List;

public interface OrdersService {
    int createOrders(Orders orders);
    Orders getOrdersById(Integer orderId);
    List<Orders> listOrdersByUserId(String userId);
}
