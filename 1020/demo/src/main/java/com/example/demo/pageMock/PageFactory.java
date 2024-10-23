package com.example.demo.pageMock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PageFactory {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private RegisterPage registerPage;

    @Autowired
    private InventoryPage inventoryPage;


    //根据参数选择 page 返回
    public Page getPage(String pageName)
    {
        if(pageName.equals("login"))
        {
            return loginPage;
        }
        else if(pageName.equals("register"))
        {
            return registerPage;
        }else if(pageName.equals("inventory")){
            return inventoryPage;
        }
        return null;
    }
}
