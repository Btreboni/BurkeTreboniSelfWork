/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FMOrderDao;
import com.sg.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author admin
 */
public class TrainingServiceImpl implements OrderService {

    FMOrderDao orderDao;
    
    public TrainingServiceImpl(FMOrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public TrainingServiceImpl() {
    }

    @Override
    public void removeOrder(int invoiceID, LocalDate date) throws PersistenceException {
        //doNothing
    }

    @Override
    public void addOrderNumber(Order order) throws PersistenceException, DuplicateIDException {
        //doNothing
    }

    @Override
    public List<Order> getOrdersList(LocalDate date) throws PersistenceException {
        return orderDao.getListOfOrder(date);
    }

    @Override
    public void setProductTaxes(Order newOrder, int[] productTaxChoices) throws PersistenceException {
        //doNothing
    }

    @Override
    public void calculations(Order newOrder) throws PersistenceException {
        //doNothing
    }

    @Override
    public void updateOrder(Order orderToUpdate, LocalDate originalOrderDate) throws PersistenceException {
        //doNothing
    }

    @Override
    public Order addOrder(Order order, boolean isConfirmed) throws PersistenceException {
        Order newOrder = new Order();
        return newOrder;
    }

    @Override
    public Order getOrder(int userNum, LocalDate orderDate) throws PersistenceException {
        return orderDao.getOrder(userNum, orderDate);
    }

}
