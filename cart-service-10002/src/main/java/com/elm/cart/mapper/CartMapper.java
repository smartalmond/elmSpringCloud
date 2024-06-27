package com.elm.cart.mapper;

import com.elm.cart.domain.DTO.CartParams;
import com.elm.cart.domain.pojo.Cart;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CartMapper {

    public List<Cart> listCart(Cart cart);

    @Options(useGeneratedKeys = true, keyProperty = "cartId")
    @Insert("INSERT INTO cart (businessId, foodId, userId, quantity) VALUES (#{businessId}, #{foodId}, #{userId}, 1)")
    public int saveCart(CartParams cp);

    @Update("update cart set quantity=#{quantity} where foodId=#{foodId} and businessId=#{businessId} and userId=#{userId}")
    public int updateCart(@Param("foodId")Integer foodId, @Param("businessId")Integer businessId,
                          @Param("userId")String userId, @Param("quantity")Integer quantity);

    public int removeCart(Cart cart);
}
