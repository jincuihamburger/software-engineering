package com.example.demo.pageMock;

import com.example.demo.controller.AdminController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryPage implements Page{

    @Autowired
    AdminController adminController;

    public void clickManagementButton(){
        adminController.getProductItems();
    }
}
