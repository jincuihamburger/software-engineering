package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    public String login(String username, String password);

    public String register(String username, String password);

    public User getUserInfo(String username);
}
