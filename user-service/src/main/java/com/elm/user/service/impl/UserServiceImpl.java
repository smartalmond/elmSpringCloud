package com.elm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.elm.user.mapper.UserMapper;
import com.elm.user.pojo.User;
import com.elm.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;

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
