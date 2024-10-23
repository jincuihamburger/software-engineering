package com.example.demo.pageMock;

import com.example.demo.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPage implements Page{
    @Autowired
    private UserController userController;

    private String username;

    private String password;

    public void clickLoginButton()
    {
        userController.login(username, password);
    }


}
