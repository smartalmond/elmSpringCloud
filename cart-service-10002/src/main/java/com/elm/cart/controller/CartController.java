package com.elm.cart.controller;

import com.elm.cart.domain.pojo.*;
import com.elm.cart.service.CartService;
import com.elm.common.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CartController")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/listCart1")
    public CommonResult<List> listCart() throws Exception{
        Cart param = new Cart();
        String userId = UserContext.getUser();
        param.setUserId(userId);
        param.setBusinessId(null);
        List<Cart> list = cartService.listCart(param);
        return new CommonResult<>(200,"success",list);
    }

    @GetMapping("/listCart2")
    @ResponseBody
    public CommonResult<List> listCart(
            @RequestParam("businessId") Integer businessId) throws Exception{
        Cart param = new Cart();
        String userId = UserContext.getUser();
        param.setUserId(userId);
        param.setBusinessId(businessId);
        List<Cart> list = cartService.listCart(param);
        return new CommonResult<>(200,"success",list);
    }

    @PostMapping("/saveCart")
    public CommonResult<Integer> saveCart(
            @RequestParam("businessId") Integer businessId,
            @RequestParam("foodId") Integer foodId) throws Exception{
        Cart param = new Cart();
        String userId = UserContext.getUser();
        param.setUserId(userId);
        param.setBusinessId(businessId);
        param.setFoodId(foodId);
        int result = cartService.saveCart(param);
        return new CommonResult<>(200,"success",result);
    }

    @PutMapping("/updateCart")
    public CommonResult<Integer> updateCart(
            @RequestParam("businessId") Integer businessId,
            @RequestParam("foodId") Integer foodId,
            @RequestParam("quantity") Integer quantity) throws Exception{
        Cart param = new Cart();
        String userId = UserContext.getUser();
        param.setUserId(userId);
        param.setBusinessId(businessId);
        param.setFoodId(foodId);
        param.setQuantity(quantity);
        int result = cartService.updateCart(param);
        return new CommonResult<>(200,"success", result);
    }

    @DeleteMapping("/removeCart")
    public CommonResult<Integer> removeCart(
            @RequestParam("businessId") Integer businessId,
            @RequestParam(value = "foodId", required = false) String foodIdStr) throws Exception {

        Integer foodId = null;
        if (foodIdStr != null && !"null".equalsIgnoreCase(foodIdStr)) {
            try {
                foodId = Integer.parseInt(foodIdStr);
            } catch (NumberFormatException e) {
                // 处理转换异常，例如返回错误码和消息
                return new CommonResult<>(400, "Invalid foodId format", null);
            }
        }

        Cart param = new Cart();
        String userId = UserContext.getUser();
        param.setUserId(userId);
        param.setBusinessId(businessId);
        if (foodId != null) {
            param.setFoodId(foodId);
        }

        int result = cartService.removeCart(param);
        return new CommonResult<>(200, "success", result);
    }
}
