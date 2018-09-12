/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.service.PersistenceException;

/**
 *
 * @author admin
 */
public interface FMOrderNumberDao {
 
    public int loadOrderNumber() throws PersistenceException;
    
    public void saveOrderNumber(int orderNum) throws PersistenceException;
    
}
