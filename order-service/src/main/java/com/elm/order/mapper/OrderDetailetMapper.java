package com.elm.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elm.order.pojo.OrderDetailet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDetailetMapper extends BaseMapper<OrderDetailet> {
    int saveOrderDetailetBatch(List<OrderDetailet> list);
}
