package com.elm.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.elm.business.mapper.BusinessMapper;
import com.elm.business.pojo.Business;
import com.elm.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        QueryWrapper<Business> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_type_id", orderTypeId);
        return businessMapper.selectList(queryWrapper);
    }

    @Override
    public Business getBusinessById(Integer businessId) {
        return businessMapper.selectById(businessId);
    }

}
