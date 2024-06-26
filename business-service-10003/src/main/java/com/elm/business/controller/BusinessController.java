package com.elm.business.controller;

import com.elm.business.feign.FoodFeignClient;
import com.elm.business.po.Business;
import com.elm.business.po.CommonResult;
import com.elm.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/BusinessController")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @Qualifier("com.elm.business.feign.FoodFeignClient")
    @Autowired
    private FoodFeignClient fc;

    @RequestMapping("/listBusinessByOrderTypeId")
    public List<Business> listBusinessByOrderTypeId(@RequestParam Integer orderTypeId) throws Exception{
        return businessService.listBusinessByOrderTypeId(orderTypeId);
    }

    @RequestMapping("/getBusinessById")
    public Business getBusinessById(@RequestParam Integer businessId) throws Exception{
        return businessService.getBusinessById(businessId);
    }

    @RequestMapping("/ListBusinessByNum")
    public List<Business> ListBusinessByNum(Integer num) throws Exception{
        return businessService.listBusinessByNum(num);
    }

    @RequestMapping("/listFoodByBusinessId")
    public CommonResult<List> listFoodByBusinessId(@RequestParam("businessId") Integer businessId) throws Exception{
        return fc.listFoodByBusinessId(businessId);
    }

} 
