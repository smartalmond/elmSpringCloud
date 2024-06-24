package com.elm.cart.pojo;

import lombok.Data;

@Data
public class Cart {
	private Integer cartId;
	private Integer foodId;
	private Integer businessId;
	private String userId;
	private Integer quantity;
}
