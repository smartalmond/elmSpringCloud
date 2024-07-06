package com.elm.food.pojo;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
public class Food {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer foodId;

	@Column(nullable = false)
	private String foodName;

	@Column(nullable = false)
	private String foodExplain;

	@Column(nullable = false)
	private String foodImg;

	@Column(nullable = false)
	private Double foodPrice;

	private String remarks;

	@Column(nullable = false)
	private Integer businessId;
}

