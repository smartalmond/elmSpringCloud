package com.ynu.elm.service.impl;

import com.ynu.elm.mapper.BusinessMapper;
import com.ynu.elm.po.Business;
import com.ynu.elm.service.BusinessService;
import com.ynu.elm.util.DistanceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        return businessMapper.listBusinessByOrderTypeId(orderTypeId);
    }

    @Override
    public Business getBusinessById(Integer businessId) {
        return businessMapper.getBusinessById(businessId);
    }

    @Override
    public List<Business> listBusinessByNum(Integer num){
        return businessMapper.listBusinessByNum(num);
    }
}
