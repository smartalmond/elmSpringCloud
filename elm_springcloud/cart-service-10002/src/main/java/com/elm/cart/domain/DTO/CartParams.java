package com.elm.cart.domain.DTO;

import lombok.Data;

@Data
public class CartParams {
    private Integer cartId;

    private Integer businessId;

    private Integer foodId;

    private String userId;

}
