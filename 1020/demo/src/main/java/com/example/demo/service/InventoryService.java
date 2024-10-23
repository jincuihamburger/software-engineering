package com.example.demo.service;

import com.example.demo.entity.ProductItem;

import java.util.List;

public interface InventoryService {
    public boolean addItem(String itemID, String itemName, String itemType, String itemPrice);

    public boolean removeItem(String itemID);

    public boolean updateItem(String itemID, String itemName, String itemType, String itemPrice);

    //getProductItemList
    public List<ProductItem> getProductItems();

    public ProductItem getProductItem(String itemID);

}
