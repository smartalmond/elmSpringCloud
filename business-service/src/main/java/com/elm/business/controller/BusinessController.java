package com.elm.business.controller;

import com.elm.business.pojo.Business;
import com.elm.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/BusinessController")
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @RequestMapping("/listBusinessByOrderTypeId")
    public List<Business> listBusinessByOrderTypeId(Business business){
        return businessService.listBusinessByOrderTypeId(business.getOrderTypeId());
    }

    @RequestMapping("getBusinessById")
    public Business getBusinessById(Business business){
        return businessService.getBusinessById(business.getBusinessId());
    }
}
