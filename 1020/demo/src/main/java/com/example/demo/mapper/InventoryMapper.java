package com.example.demo.mapper;

import com.example.demo.entity.ProductItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InventoryMapper {

    public boolean addItem(String itemID, String itemName, String itemType, String itemPrice);

    public ProductItem getProductItem(String itemID);

    public List<ProductItem> getProductItems();

    public boolean removeItem(String itemID);

    public boolean updateItem(String itemID, String itemName, String itemType, String itemPrice);
}
