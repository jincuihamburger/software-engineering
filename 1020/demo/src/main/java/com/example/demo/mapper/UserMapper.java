package com.example.demo.mapper;


import com.example.demo.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    public User getUserInfo(String username);
    public boolean login(String username, String password);

    public boolean register(String username, String password);
}
