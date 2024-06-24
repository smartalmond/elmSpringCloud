package com.elm.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.elm.order.mapper.OrderDetailetMapper;
import com.elm.order.pojo.OrderDetailet;
import com.elm.order.service.OrderDetailetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailetServiceImpl implements OrderDetailetService {
    @Autowired
    private OrderDetailetMapper orderDetailetMapper;

    @Override
    public int saveOrderDetailetBatch(List<OrderDetailet> list) {
        return orderDetailetMapper.saveOrderDetailetBatch(list);
    }

    @Override
    public List<OrderDetailet> listOrderDetailetByOrderId(Integer orderId) {
        QueryWrapper<OrderDetailet> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", orderId);
        return orderDetailetMapper.selectList(queryWrapper);
    }
}
