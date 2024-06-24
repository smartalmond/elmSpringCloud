package com.elm.business.po;

import lombok.Data;
import javax.persistence.*;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "businessId")
    private Business business;
}
