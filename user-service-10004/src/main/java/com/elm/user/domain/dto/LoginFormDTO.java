package com.elm.user.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginFormDTO {
    @NotNull(message = "用户Id不能为空")
    private String userId;
    @NotNull(message = "密码不能为空")
    private String password;
}
