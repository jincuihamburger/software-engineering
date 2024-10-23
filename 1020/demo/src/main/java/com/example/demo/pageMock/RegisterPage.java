package com.example.demo.pageMock;

import com.example.demo.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterPage implements Page{

    @Autowired
    private UserController userController;

    private String username;

    private String password;

    public void clickRegisterButton()
    {
        userController.register(username, password);
    }
}
