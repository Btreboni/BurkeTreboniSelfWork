/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface VMVendingDAO {
    
    public List<Item> listItems() throws VMPersistenceException;
    
    public Item getItem(String itemId) throws VMPersistenceException;
    
    public void updateItem(Item itemToUpdate) throws VMPersistenceException;
    
    public Item addItem(Item item) throws VMPersistenceException;
    
    public Item removeItem(String item) throws VMPersistenceException;
}
