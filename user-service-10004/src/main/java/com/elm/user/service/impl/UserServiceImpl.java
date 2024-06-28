package com.elm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.elm.common.exception.BadRequestException;
import com.elm.user.config.JwtProperties;
import com.elm.user.domain.dto.LoginFormDTO;
import com.elm.user.domain.po.User;
import com.elm.user.domain.vo.UserLoginVO;
import com.elm.user.mapper.UserMapper;
import com.elm.user.service.UserService;
import com.elm.user.utils.JwtTool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    private final JwtTool jwtTool;

    private final JwtProperties jwtProperties;

    @Override
    public UserLoginVO login(LoginFormDTO loginDTO) {
        // 1.数据校验
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        // 2.根据用户名或手机号查询
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName", username);
        User user = userMapper.selectOne(queryWrapper);
        Assert.notNull(user, "用户名错误");
        // 3.校验密码
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadRequestException("用户名或密码错误");
        }
        // 4.生成TOKEN
        String token = jwtTool.createToken(user.getUserId(), jwtProperties.getTokenTTL());
        // 5.封装VO返回
        UserLoginVO vo = new UserLoginVO();
        vo.setUserId(user.getUserId());
        vo.setUsername(user.getUserName());
        vo.setToken(token);
        return vo;
    }

    @Override
    public User getUserByIdByPass(String userId, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("password", password);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public User getUserById(String userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public int saveUser(User user) {
        return userMapper.insert(user);
    }
}
