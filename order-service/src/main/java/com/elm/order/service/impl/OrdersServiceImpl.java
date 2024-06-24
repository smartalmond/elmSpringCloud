package com.elm.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.elm.order.mapper.OrdersMapper;
import com.elm.order.pojo.Orders;
import com.elm.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public int createOrders(Orders orders) {
        return ordersMapper.insert(orders);
    }

    @Override
    public Orders getOrdersById(Integer orderId) {
        return ordersMapper.selectById(orderId);
    }

    @Override
    public List<Orders> listOrdersByUserId(String userId) {
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return ordersMapper.selectList(queryWrapper);
    }
}
