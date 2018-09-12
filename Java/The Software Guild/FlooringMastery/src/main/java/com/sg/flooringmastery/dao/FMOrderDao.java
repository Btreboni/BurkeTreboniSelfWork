/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.service.PersistenceException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author admin
 */
public interface FMOrderDao {

    public List<Order> getListOfOrder(LocalDate date) throws PersistenceException;

    public void editOrder(Order order) throws PersistenceException;

    public Order addOrder(Order order, boolean isConfirmed) throws PersistenceException;

    public void removeOrder(int invoiceID, LocalDate date) throws PersistenceException;

    public String generateOrderFileName(LocalDate date) throws PersistenceException;

    public String generateTempOrderFileName(LocalDate date) throws PersistenceException;

    public Order getOrder(Integer invoiceID, LocalDate date) throws PersistenceException;


}
