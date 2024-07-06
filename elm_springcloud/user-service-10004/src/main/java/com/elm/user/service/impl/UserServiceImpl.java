package com.elm.user.service.impl;

import com.elm.common.exception.BadRequestException;
import com.elm.user.config.JwtProperties;
import com.elm.user.domain.dto.LoginFormDTO;
import com.elm.user.domain.dto.RegisterFormDTO;
import com.elm.user.domain.po.User;
import com.elm.user.domain.vo.UserLoginVO;
import com.elm.user.mapper.UserMapper;
import com.elm.user.service.UserService;
import com.elm.user.utils.JwtTool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final JwtTool jwtTool;

    private final JwtProperties jwtProperties;

    @Override
    public UserLoginVO getUserByIdByPass(LoginFormDTO loginFormDTO) {
        // 1.数据校验
        String userId = loginFormDTO.getUserId();
        String password = loginFormDTO.getPassword();
        // 2.根据用户名或手机号查询
        User user = userMapper.getUserById(userId);
        Assert.notNull(user, "手机号错误");
        // 3.校验密码
        if (!password.equals(user.getPassword())) {
            throw new BadRequestException("手机号或密码错误");
        }
        // 4.生成TOKEN
        String token = jwtTool.createToken(user.getUserId(), jwtProperties.getTokenTTL());
        // 5.封装VO返回
        UserLoginVO vo = new UserLoginVO();
        vo.setUserId(user.getUserId());
        vo.setUserName(user.getUserName());
        vo.setToken(token);
        return vo;
    }

    @Override
    public User getUserById(String userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public int saveUser(RegisterFormDTO registerFormDTO) {
        return userMapper.saveUser(registerFormDTO);
    }
}
