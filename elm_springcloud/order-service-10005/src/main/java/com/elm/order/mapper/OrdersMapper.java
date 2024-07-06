package com.elm.order.mapper;

import com.elm.order.pojo.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrdersMapper {

    public Integer saveOrders(Orders orders);

    @Select("select * from orders where orderId=#{orderId}")
    public Orders getOrdersById(Integer orderID);

    @Select("select * from orders where userId=#{userId} order by orderId")
    public List<Orders> listOrdersByUserId(String userId);
}

