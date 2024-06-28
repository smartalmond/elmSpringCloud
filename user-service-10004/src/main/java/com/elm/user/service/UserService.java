package com.elm.user.service;


import com.elm.user.domain.dto.LoginFormDTO;
import com.elm.user.domain.po.User;
import com.elm.user.domain.vo.UserLoginVO;

public interface UserService {
    UserLoginVO login(LoginFormDTO loginFormDTO);
    User getUserByIdByPass(String userId, String password);
    User getUserById(String userId);
    int saveUser(User user);
}
