package com.elm.order.controller;

import com.elm.order.pojo.Orders;
import com.elm.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/OrdersController")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/createOrders")
    public int createOrders(Orders orders){
        return ordersService.createOrders(orders);
    }

    @RequestMapping("/getOrdersById")
    public Orders getOrdersById(Orders orders){
        return ordersService.getOrdersById(orders.getOrderId());
    }

    @RequestMapping("/listOrdersByUserId")
    public List<Orders> listOrdersByUserId(Orders orders){
        return ordersService.listOrdersByUserId(orders.getUserId());
    }
}
