package com.elm.user.controller;

import com.elm.user.domain.dto.LoginFormDTO;
import com.elm.user.domain.dto.RegisterFormDTO;
import com.elm.user.domain.po.CommonResult;
import com.elm.user.domain.po.User;
import com.elm.user.domain.vo.UserLoginVO;
import com.elm.user.feign.AddressFeignClient;
import com.elm.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/UserController")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AddressFeignClient ad;

    @RequestMapping("/getUserByIdByPass")
    public UserLoginVO getUserByIdByPass(@RequestBody LoginFormDTO loginFormDTO){
        return userService.getUserByIdByPass(loginFormDTO);
    }

    @RequestMapping("/getUserById")
    public User getUserById(String userId){
        return userService.getUserById(userId);
    }

    @RequestMapping("/saveUser")
    public CommonResult<Integer> saveUser(@RequestBody RegisterFormDTO registerFormDTO){
        int result = userService.saveUser(registerFormDTO);
        return new CommonResult<>(200, "success", result);
    }

    @RequestMapping("/listDeliveryAddressByUserId")
    public CommonResult<List> listDeliveryAddressByUserId(@RequestParam("userId") String userId){
        return ad.listDeliveryAddressByUserId(userId);
    }
}

