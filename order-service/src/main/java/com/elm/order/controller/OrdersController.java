package com.elm.order.controller;

import com.elm.order.pojo.CommonResult;
import com.elm.order.pojo.Orders;
import com.elm.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OrdersController")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/createOrders")
    public CommonResult<Integer> createOrders(
            @RequestParam("userId") String userId,
            @RequestParam("businessId") Integer businessId,
            @RequestParam("daId") Integer daId,
            @RequestParam("orderTotal") Double orderTotal) throws Exception {
        Orders orders = new Orders();
        orders.setUserId(userId);
        orders.setBusinessId(businessId);
        orders.setDaId(daId);
        orders.setOrderTotal(orderTotal);
        int orderId = ordersService.createOrders(orders);
        return new CommonResult<>(200, "success", orderId);
    }

    @GetMapping("/getOrdersById")
    public CommonResult<Orders> getOrdersById(@RequestParam("orderId") Integer orderId) throws Exception {
        Orders orders = ordersService.getOrdersById(orderId);
        return new CommonResult<>(200, "success", orders);
    }

    @GetMapping("/listOrdersByUserId")
    public CommonResult<List<Orders>> listOrdersByUserId(@RequestParam("userId") String userId) throws Exception {
        List<Orders> list = ordersService.listOrdersByUserId(userId);
        return new CommonResult<>(200, "success", list);
    }
}
