package com.elm.user.domain.po;

import lombok.Data;

@Data
public class DeliveryAddress {
	private Integer daId; 
	private String contactName;
	private Integer contactSex;
	private String contactTel;
	private String address; 
	private String userId;

}
