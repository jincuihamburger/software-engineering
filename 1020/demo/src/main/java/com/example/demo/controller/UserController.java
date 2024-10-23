package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.pageMock.Page;
import com.example.demo.pageMock.PageFactory;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PageFactory pageFactory;

    @RequestMapping("/register")
    public Page register(String username, String password){
        String success = userService.register(username, password);
        if(success.equals("success") ) return pageFactory.getPage("login");
        return pageFactory.getPage("register");
    }

    @RequestMapping("/login")
    public String login(String username, String password){
        return userService.login(username, password);
    }
}
