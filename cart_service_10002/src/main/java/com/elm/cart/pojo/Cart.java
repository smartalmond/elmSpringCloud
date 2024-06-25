package com.elm.cart.pojo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer cartId;

	@Column(nullable = false)
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "businessId")
	private Business business;

	@Column(nullable = false)
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "foodId")
	private Food food;

	@Column(nullable = false)
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;

	@Column(nullable = false)
	private Integer quantity;
}
