/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author admin
 */
public interface OrderService {

    public void removeOrder(int invoiceID, LocalDate date) throws PersistenceException;

    public void addOrderNumber(Order order) throws PersistenceException, DuplicateIDException;

    public List<Order> getOrdersList(LocalDate date) throws PersistenceException;

    public void setProductTaxes(Order newOrder, int[] productTaxChoices) throws PersistenceException;

    public void calculations(Order newOrder) throws PersistenceException;

    public void updateOrder(Order orderToUpdate, LocalDate originalOrderDate) throws PersistenceException;
    
    public Order addOrder(Order order, boolean isConfirmed) throws PersistenceException;

    public Order getOrder(int userNum, LocalDate orderDate) throws PersistenceException;
    
    
}
