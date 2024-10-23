package com.example.demo.service;

import com.example.demo.entity.ProductItem;
import com.example.demo.mapper.InventoryMapper;
import com.example.demo.thirdParty.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryMapper inventoryMapper;

    @Autowired
    private Sender sender;
    @Override
    public boolean addItem(String itemID, String itemName, String itemType, String itemPrice) {
        boolean b = inventoryMapper.addItem(itemID, itemName, itemType, itemPrice);
        if (b) {
            sender.send("New item added: " + itemID);
        }
        return b;
    }

    @Override
    public boolean removeItem(String itemID) {
        boolean b = inventoryMapper.removeItem(itemID);
        if (b) {
            sender.send("Item removed: " + itemID);
        }
        return b;
    }

    @Override
    public boolean updateItem(String itemID, String itemName, String itemType, String itemPrice) {
        boolean b = inventoryMapper.updateItem(itemID, itemName, itemType, itemPrice);
        if (b) {
            sender.send("Item updated: " + itemID);
        }
        return b;
    }

    @Override
    public List<ProductItem> getProductItems() {
        return inventoryMapper.getProductItems();
    }

    @Override
    public ProductItem getProductItem(String itemID) {
        return inventoryMapper.getProductItem(itemID);
    }
}
