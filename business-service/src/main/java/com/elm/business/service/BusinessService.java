package com.ynu.elm.service;

import com.ynu.elm.po.Business;

import java.util.List;

public interface BusinessService {

    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);

    public Business getBusinessById(Integer businessId);

    public List<Business> listBusinessByNum(Integer num);
}
