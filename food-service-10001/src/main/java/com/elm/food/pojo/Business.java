package com.elm.food.pojo;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
public class Business {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer businessId;

    @Column(nullable = false)
    private String businessName;

    private String businessAddress;

    private String businessExplain;

    @Column(nullable = false)
    private String businessImg;

    @Column(nullable = false)
    private Integer orderTypeId;

    private Double starPrice;

    private Double deliveryPrice;

    private String remarks;

    private Integer weight;

}
