package com.elm.food.pojo;

import lombok.Data;

@Data
public class Food {
	private Integer foodId;
	private String foodName;
	private String foodExplain;
	private String foodImg;
	private Double foodPrice;
	private Integer businessId;
	private String remarks;
}

