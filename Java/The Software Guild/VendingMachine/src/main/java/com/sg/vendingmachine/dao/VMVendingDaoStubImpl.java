/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class VMVendingDaoStubImpl implements VMVendingDAO {

    Item onlyItem;
    List<Item> itemList = new ArrayList<>();

    public VMVendingDaoStubImpl() {
        onlyItem = new Item("1");
        onlyItem.setItemName("Lagunitas");
        onlyItem.setPrice(new BigDecimal(3.00));
        onlyItem.setQuantity(11);

        itemList.add(onlyItem);
    }

    @Override
    public List<Item> listItems() throws VMPersistenceException {
        return itemList;
    }

    @Override
    public Item getItem(String itemId) throws VMPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateItem(Item itemToUpdate) throws VMPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item addItem(Item item) throws VMPersistenceException {
        if (item.equals(onlyItem.getItemId())) {
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public Item removeItem(String item) throws VMPersistenceException {
        if (item.equals(onlyItem.getItemId())) {
            return onlyItem;
        } else {
            return null;
        }
        
        
    }
}
