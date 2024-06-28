package com.elm.user.domain.vo;

import lombok.Data;

@Data
public class UserLoginVO {
    private String token;
    private String userId;
    private String username;
}
