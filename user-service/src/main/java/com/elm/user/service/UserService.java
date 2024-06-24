package com.elm.user.service;


import com.elm.user.pojo.User;

public interface UserService {
    User getUserByIdByPass(String userId, String password);
    User getUserById(String userId);
    int saveUser(User user);
}
