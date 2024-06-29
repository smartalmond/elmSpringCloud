package com.elm.user.controller;

import com.elm.user.domain.dto.LoginFormDTO;
import com.elm.user.domain.po.CommonResult;
import com.elm.user.domain.po.User;
import com.elm.user.domain.vo.UserLoginVO;
import com.elm.user.feign.AddressFeignClient;
import com.elm.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @RequestMapping("/login")
    public UserLoginVO login(LoginFormDTO loginFormDTO){
        return userService.login(loginFormDTO);
    }
    @RequestMapping("/getUserByIdByPass")
    public User getUserByIdByPass(String userId, String password){
        return userService.getUserByIdByPass(userId,password);
    }
    @RequestMapping("/getUserById")
    public User getUserById(String userId){
        return userService.getUserById(userId);
    }
    @RequestMapping("/saveUser")
    public int saveUser(User user){
        return userService.saveUser(user);
    }

    @RequestMapping("/listDeliveryAddressByUserId")
    public CommonResult<List> listDeliveryAddressByUserId(@RequestParam("userId") String userId) throws Exception{
        return ad.listDeliveryAddressByUserId(userId);
    }
}
