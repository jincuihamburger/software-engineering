package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Override
    public String login(String username, String password) {
        if(userMapper.login(username, password)){
            return "true";
        }
        return "false";
    }

    @Override
    public String register(String username, String password) {
        User userInfo = userMapper.getUserInfo(username);
        if(userInfo != null){
            return "false";
        }
        if(userMapper.register(username, password)){
            return "true";
        }
        return "false";
    }

    @Override
    public User getUserInfo(String username) {
        return userMapper.getUserInfo(username);
    }
}
