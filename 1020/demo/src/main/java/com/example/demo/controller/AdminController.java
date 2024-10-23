package com.example.demo.controller;

import com.example.demo.entity.ProductItem;
import com.example.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private InventoryService inventoryService;

    @RequestMapping("/addItem")
    public boolean addItem(String itemID, String itemName, String itemType, String itemPrice)
    {
        return inventoryService.addItem(itemID, itemName, itemType, itemPrice);
    }

    @RequestMapping("/removeItem")
    public ProductItem getProductItem(String itemID)
    {
        return inventoryService.getProductItem(itemID);
    }

    @RequestMapping("/updateItem")
    public List<ProductItem> getProductItems()
    {
        return inventoryService.getProductItems();
    }
}
