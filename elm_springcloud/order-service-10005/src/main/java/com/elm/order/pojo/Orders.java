package com.elm.order.pojo;

import lombok.Data;

import jakarta.persistence.*;
@Data
@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer orderId;

	@Column(nullable = false)
	private String userId;

	@Column(nullable = false)
	private Integer businessId;

	@Column(nullable = false)
	private String orderDate;

	@Column(nullable = false)
	private Double orderTotal;

	@Column(nullable = false)
	private Integer daId;

	@Column(nullable = false)
	private Integer orderState;

}
