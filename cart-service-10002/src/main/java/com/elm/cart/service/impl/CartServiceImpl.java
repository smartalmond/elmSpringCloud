package com.elm.cart.service.impl;

import com.elm.cart.domain.DTO.CartParams;
import com.elm.cart.mapper.CartMapper;
import com.elm.cart.domain.pojo.Cart;
import com.elm.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<Cart> listCart(Cart cart) {
        return cartMapper.listCart(cart);
    }

    @Override
    public int saveCart(Cart cart) {
        Integer foodId = cart.getFoodId();
        Integer businessId = cart.getBusinessId();
        String userId = cart.getUserId();
        CartParams cp=new CartParams();
        cp.setBusinessId(businessId);
        cp.setUserId(userId);
        cp.setFoodId(foodId);
        return cartMapper.saveCart(cp);
    }

    @Override
    public int updateCart(Cart cart) {
        Integer foodId = cart.getFoodId();
        Integer businessId = cart.getBusinessId();
        String userId = cart.getUserId();
        Integer quantity = cart.getQuantity();
        return cartMapper.updateCart(foodId,businessId,userId,quantity);
    }

    @Override
    public int removeCart(Cart cart) {
        return cartMapper.removeCart(cart);
    }
}

