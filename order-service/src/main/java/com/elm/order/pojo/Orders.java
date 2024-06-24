package com.elm.order.pojo;

import lombok.Data;

@Data
public class Orders {
	private Integer orderId;
	private String userId;
	private Integer businessId;
	private String orderDate;
	private Double orderTotal;
	private Integer daId;
	private Integer orderState;

}
