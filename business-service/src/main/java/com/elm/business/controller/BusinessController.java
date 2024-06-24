package com.elm.business.controller;

import com.elm.business.po.Business;
import com.elm.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/BusinessController")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping("/listBusinessByOrderTypeId")
    public List<Business> listBusinessByOrderTypeId(@RequestBody Business business) throws Exception{
        return businessService.listBusinessByOrderTypeId(business.getOrderTypeId());
    }

    @RequestMapping("/getBusinessById")
    public Business getBusinessById(@RequestBody Business business) throws Exception{
        return businessService.getBusinessById(business.getBusinessId());
    }

    @RequestMapping("/ListBusiness")
    public List<Business> ListBusinessByNum(Integer num) throws Exception{
        return businessService.listBusinessByNum(num);
    }

} 
