package com.elm.cart.domain.pojo;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private String userId;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String userName;

	@Column(nullable = false)
	private Integer userSex;

	private String userImg;

	@Column(nullable = false)
	private Integer delTag;
}
