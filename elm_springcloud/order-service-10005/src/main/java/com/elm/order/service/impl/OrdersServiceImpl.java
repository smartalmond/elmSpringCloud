package com.elm.order.service.impl;

import com.elm.common.utils.UserContext;
import com.elm.order.feign.CartFeignClient;
import com.elm.order.mapper.OrderDetailetMapper;
import com.elm.order.mapper.OrdersMapper;
import com.elm.order.pojo.Cart;
import com.elm.order.pojo.CommonResult;
import com.elm.order.pojo.OrderDetailet;
import com.elm.order.pojo.Orders;
import com.elm.order.service.OrdersService;
import com.elm.order.util.CommonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Qualifier("com.elm.order.feign.CartFeignClient")
    @Autowired
    private CartFeignClient csc;

    @Autowired
    private OrderDetailetMapper orderDetailetMapper;

    @Override
    @Transactional
    public int createOrders(Orders orders) {
        //1、查询当前用户购物车中当前商家的所有食品
        CommonResult<List> cartList = csc.listCarts(orders.getUserId(), orders.getBusinessId());
        //2、创建订单（返回生成的订单编号）
        orders.setOrderDate(CommonUtil.getCurrentDate());
        ordersMapper.saveOrders(orders);
        int orderId = orders.getOrderId();

        //3、批量添加订单明细
        List<OrderDetailet> list = new ArrayList<>();
        if (cartList != null && cartList.getCode() == 200) {

            //显式处理json数据
            ObjectMapper mapper = new ObjectMapper();
            List<Cart> carts = mapper.convertValue(cartList.getResult(), new TypeReference<List<Cart>>() {});

            for (Cart c : carts) {
                OrderDetailet od = new OrderDetailet();
                od.setOrderId(orderId);
                od.setFoodId(c.getFoodId());
                od.setQuantity(c.getQuantity());
                list.add(od);
            }
            if (!list.isEmpty()) {
                orderDetailetMapper.saveOrderDetailetBatch(list);
            }
        }

        //5、从购物车表中删除相关食品信息
        csc.removeCart(UserContext.getUser(), orders.getBusinessId(), null);

        return orderId;
    }

    @Override
    public Orders getOrdersById (Integer orderId){
        return ordersMapper.getOrdersById(orderId);
    }

    @Override
    public List<Orders> listOrdersByUserId (String userId){
        return ordersMapper.listOrdersByUserId(userId);
    }
}
