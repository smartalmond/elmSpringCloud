package com.elm.business.service.impl;

import com.elm.business.mapper.BusinessMapper;
import com.elm.business.po.Business;
import com.elm.business.service.BusinessService;
import com.elm.business.util.DistanceUtils;
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
