package com.elm.cart.domain.pojo;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer cartId;

	@Column(nullable = false)
	private Integer businessId;

	@Column(nullable = false)
	private Integer foodId;

	@Column(nullable = false)
	private String userId;

	@Column(nullable = false)
	private Integer quantity;
}
