/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VMDataValidationException;
import com.sg.vendingmachine.dao.VMDuplicateIDException;
import com.sg.vendingmachine.dao.VMPersistenceException;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author admin
 */
public interface VMService {
    
    public Item vendItem(String itemId, BigDecimal userDough) 
            throws VMPersistenceException, InsufficientFundsException, NoItemInventoryException;
    
    public List<Change> calculateChange(Item itemToVend, BigDecimal userDough);
    
    public List<Item> listItems() throws VMPersistenceException;
   
    public void addItem(Item item) throws VMPersistenceException, 
            VMDataValidationException,VMDuplicateIDException;
    
    public void removeItem(String itemId) throws VMPersistenceException;
    
}
