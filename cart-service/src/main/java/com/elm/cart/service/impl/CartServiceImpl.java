package com.elm.cart.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.elm.cart.mapper.CartMapper;
import com.elm.cart.pojo.Cart;
import com.elm.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<Cart> listCart(Cart cart) {
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>(cart);
        queryWrapper.eq("user_id", cart.getUserId());
        queryWrapper.eq("business_id", cart.getBusinessId());
        return cartMapper.selectList(queryWrapper);
    }

    @Override
    public int saveCart(Cart cart) {
        return cartMapper.insert(cart);
    }

    @Override
    public int updateCart(Cart cart) {
        UpdateWrapper<Cart> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id", cart.getUserId());
        updateWrapper.eq("business_id", cart.getBusinessId());
        updateWrapper.eq("food_id", cart.getFoodId());
        if (cart.getQuantity() != null)
            updateWrapper.set("quantity", cart.getQuantity());
        return cartMapper.update(updateWrapper);
    }

    @Override
    public int removeCart(Cart cart) {
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>(cart);
        queryWrapper.eq("user_id", cart.getUserId());
        queryWrapper.eq("business_id", cart.getBusinessId());
        queryWrapper.eq("food_id", cart.getFoodId());
        return cartMapper.delete(queryWrapper);
    }
}
