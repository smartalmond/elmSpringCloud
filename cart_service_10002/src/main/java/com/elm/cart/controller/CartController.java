package com.elm.cart.controller;

import com.elm.cart.pojo.*;
import com.elm.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CartController")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/listCart/{userId}")
    public CommonResult<List> listCart(@PathVariable("userId") String userId) throws Exception{
        Cart param = new Cart();
        User u = new User();
        u.setUserId(userId);
        Business b = new Business();
        b.setBusinessId(null);
        param.setUser(u);
        param.setBusiness(b);
        List<Cart> list = cartService.listCart(param);
        return new CommonResult<>(200,"success",list);
    }

    @GetMapping("/listCart/{userId}/{businessId}")
    public CommonResult<List> listCart(
            @PathVariable("userId") String userId,
            @PathVariable("businessId") Integer businessId) throws Exception{
        Cart param = new Cart();
        Business b = new Business();
        b.setBusinessId(businessId);
        User u = new User();
        u.setUserId(userId);
        param.setUser(u);
        param.setBusiness(b);
        List<Cart> list = cartService.listCart(param);
        return new CommonResult<>(200,"success",list);
    }

    @PostMapping("/saveCart/{userId}/{businessId}/{foodId}")
    public CommonResult<Integer> saveCart(
            @PathVariable("userId") String userId,
            @PathVariable("businessId") Integer businessId,
            @PathVariable("foodId") Integer foodId) throws Exception{
        Cart param = new Cart();
        User u = new User();
        Business b = new Business();
        Food f = new Food();
        u.setUserId(userId);
        f.setFoodId(foodId);
        b.setBusinessId(businessId);
        param.setUser(u);
        param.setBusiness(b);
        param.setFood(f);
        int result = cartService.saveCart(param);
        return new CommonResult<>(200,"success",result);
    }

    @PutMapping("/updateCart/{userId}/{businessId}/{foodId}/{quantity}")
    public CommonResult<Integer> updateCart(
            @PathVariable("userId") String userId,
            @PathVariable("businessId") Integer businessId,
            @PathVariable("foodId") Integer foodId,
            @PathVariable("quantity") Integer quantity) throws Exception{
        Cart param = new Cart();
        User u = new User();
        Business b = new Business();
        Food f = new Food();
        u.setUserId(userId);
        f.setFoodId(foodId);
        b.setBusinessId(businessId);
        param.setUser(u);
        param.setBusiness(b);
        param.setFood(f);
        param.setQuantity(quantity);
        int result = cartService.updateCart(param);
        return new CommonResult<>(200,"success", result);
    }

    @DeleteMapping("/removeCart/{userId}/{businessId}/{foodId}")
    public CommonResult<Integer> removeCart(
            @PathVariable("userId") String userId,
            @PathVariable("businessId") Integer businessId,
            @PathVariable("foodId") Integer foodId) throws Exception{
        Cart param = new Cart();
        User u = new User();
        Business b = new Business();
        Food f = new Food();
        u.setUserId(userId);
        f.setFoodId(foodId);
        b.setBusinessId(businessId);
        param.setUser(u);
        param.setBusiness(b);
        param.setFood(f);
        int result = cartService.removeCart(param);
        return new CommonResult<>(200,"success",result);
    }
}
