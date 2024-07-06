package com.elm.user.service;

import com.elm.user.domain.dto.LoginFormDTO;
import com.elm.user.domain.dto.RegisterFormDTO;
import com.elm.user.domain.po.User;
import com.elm.user.domain.vo.UserLoginVO;

public interface UserService {
    UserLoginVO getUserByIdByPass(LoginFormDTO loginFormDTO);

    User getUserById(String userId);

    int saveUser(RegisterFormDTO registerFormDTO);
}
