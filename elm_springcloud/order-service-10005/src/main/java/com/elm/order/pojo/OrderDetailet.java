package com.elm.order.pojo;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class OrderDetailet {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer odId;

	@Column(nullable = false)
	private Integer orderId;

	@Column(nullable = false)
	private Integer foodId;

	@Column(nullable = false)
	private Integer quantity;

}
