package com.elm.business.service;

import com.elm.business.po.Business;

import java.util.List;

public interface BusinessService {

    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);

    public Business getBusinessById(Integer businessId);

    public List<Business> listBusinessByNum(Integer num);
}
