package com.elm.business.service;

import com.elm.business.pojo.Business;

import java.util.List;

public interface BusinessService {
    List<Business> listBusinessByOrderTypeId(Integer orderTypeId);
    Business getBusinessById(Integer businessId);
}
