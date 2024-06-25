package com.elm.cart.service.impl;

import com.elm.cart.mapper.CartMapper;
import com.elm.cart.pojo.Cart;
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
        Integer businessId = cart.getBusiness().getBusinessId();
        String userId = cart.getUser().getUserId();
        Map<String, Object> params = new HashMap<>();
        params.put("businessId", businessId);
        params.put("userId", userId);
        return cartMapper.listCart(params);
    }

    @Override
    public int saveCart(Cart cart) {
        Integer foodId = cart.getFood().getFoodId();
        Integer businessId = cart.getBusiness().getBusinessId();
        String userId = cart.getUser().getUserId();
        return cartMapper.saveCart(foodId,businessId,userId);
    }

    @Override
    public int updateCart(Cart cart) {
        Integer foodId = cart.getFood().getFoodId();
        Integer businessId = cart.getBusiness().getBusinessId();
        String userId = cart.getUser().getUserId();
        Integer quantity = cart.getQuantity();
        return cartMapper.updateCart(foodId,businessId,userId,quantity);
    }

    @Override
    public int removeCart(Cart cart) {
        return cartMapper.removeCart(cart);
    }
}

