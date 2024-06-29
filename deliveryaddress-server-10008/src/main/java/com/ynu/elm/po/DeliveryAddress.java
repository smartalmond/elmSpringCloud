package com.ynu.elm.po;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DeliveryAddress {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer daId;

	@Column(nullable = false)
	private String contactName;

	@Column(nullable = false)
	private Integer contactSex;

	@Column(nullable = false)
	private String contactTel;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String userId;

}
