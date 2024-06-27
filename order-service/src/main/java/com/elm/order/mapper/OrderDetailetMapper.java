package com.elm.order.mapper;

import com.elm.order.pojo.CommonResult;
import com.elm.order.pojo.OrderDetailet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderDetailetMapper {
    int saveOrderDetailetBatch(List<OrderDetailet> list);

    @Select("select * from orderDetailet where orderId=#{orderId}")
    List<OrderDetailet> listOrderDetailetByOrderId(Integer orderId);
}
