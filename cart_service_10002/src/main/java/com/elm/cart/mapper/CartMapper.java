package com.elm.cart.mapper;

import com.elm.cart.pojo.Cart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface CartMapper {

    public List<Cart> listCart(Map<String, Object> params);

    @Insert("insert into cart values(null,#{food.foodId},#{business.businessId},#{user.userId},1)")
    public int saveCart(Integer foodId,Integer businessId,String userId);

    @Update("update cart set quantity=#{quantity} where foodId=#{foodId} and businessId=#{businessId} and userId=#{userId}")
    public int updateCart(Integer foodId,Integer businessId,String userId,Integer quantity);

    public int removeCart(Cart cart);
}
