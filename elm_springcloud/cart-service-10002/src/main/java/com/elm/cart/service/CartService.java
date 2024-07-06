package com.elm.cart.service;

import com.elm.cart.domain.pojo.Cart;

import java.util.List;

public interface CartService {

    public List<Cart> listCart(Cart cart);

    public int saveCart(Cart cart);

    public int updateCart(Cart cart);

    public int removeCart(Cart cart);
}
