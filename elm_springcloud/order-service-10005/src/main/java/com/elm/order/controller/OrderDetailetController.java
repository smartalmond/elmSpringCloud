package com.elm.order.controller;

import com.elm.order.pojo.OrderDetailet;
import com.elm.order.service.OrderDetailetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/OrderDetailetController")
public class OrderDetailetController {
    @Autowired
    private OrderDetailetService orderDetailetService;

    @RequestMapping("/saveOrderDetailetBatch")
    public int saveOrderDetailetBatch(List<OrderDetailet> list){
        return orderDetailetService.saveOrderDetailetBatch(list);
    }

    @RequestMapping("/listOrderDetailetByOrderId")
    public List<OrderDetailet> listOrderDetailetByOrderId(Integer orderId){
        return orderDetailetService.listOrderDetailetByOrderId(orderId);
    }
}
