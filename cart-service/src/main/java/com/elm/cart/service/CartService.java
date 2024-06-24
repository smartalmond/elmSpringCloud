package com.elm.cart.service;

import com.elm.cart.pojo.Cart;

import java.util.List;

public interface CartService {
    List<Cart> listCart(Cart cart);
    int saveCart(Cart cart);
    int updateCart(Cart cart);
    int removeCart(Cart cart);
}
