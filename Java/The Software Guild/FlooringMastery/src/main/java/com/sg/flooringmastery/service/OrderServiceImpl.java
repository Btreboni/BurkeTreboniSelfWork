/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FMAuditOrderDaoFileImpl;
import com.sg.flooringmastery.dao.FMOrderDao;
import com.sg.flooringmastery.dao.FMOrderDaoImpl;
import com.sg.flooringmastery.dao.FMOrderNumberDao;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author admin
 */
public class OrderServiceImpl implements OrderService {

    FMOrderDao orderDao;
    FMOrderNumberDao numDao;
    FMAuditOrderDaoFileImpl auditDao;

    public OrderServiceImpl(FMOrderDao orderDao, 
            FMOrderNumberDao numDao, FMAuditOrderDaoFileImpl auditDao) {
        this.orderDao = orderDao;
        this.numDao = numDao;
        this.auditDao = auditDao;
    }

    public OrderServiceImpl() {
    }
  

    @Override
    public void removeOrder(int invoiceID, LocalDate date) throws PersistenceException {
        orderDao.removeOrder(invoiceID, date);
    }

    @Override
    public void addOrderNumber(Order order) throws PersistenceException, DuplicateIDException {
        int orderNum = numDao.loadOrderNumber();
        order.setInvoiceID(orderNum);
        numDao.saveOrderNumber(orderNum);

    }

    @Override
    public List<Order> getOrdersList(LocalDate date) throws PersistenceException {
        return orderDao.getListOfOrder(date);
    }

    @Override
    public void setProductTaxes(Order newOrder, int[] choice) {
        //choice[0] is product, choice[1] is State
        if (choice[1] == 1) {
            Tax ohTax = new Tax("OH", new BigDecimal("6.25"));
            newOrder.setTax(ohTax);
        } else if (choice[1] == 2) {
            Tax paTax = new Tax("PA", new BigDecimal("6.75"));
            newOrder.setTax(paTax);
        } else if (choice[1] == 3) {
            Tax miTax = new Tax("MI", new BigDecimal("5.75"));
            newOrder.setTax(miTax);
        } else if (choice[1] == 4) {
            Tax inTax = new Tax("IN", new BigDecimal("6.00"));
            newOrder.setTax(inTax);
        }

        if (choice[0] == 1) {
            Product carpet = new Product("Carpet", new BigDecimal("2.25"), new BigDecimal("2.10"));
            newOrder.setProduct(carpet);
        } else if (choice[0] == 2) {
            Product laminate = new Product("Laminate", new BigDecimal("1.75"), new BigDecimal("2.10"));
            newOrder.setProduct(laminate);
        } else if (choice[0] == 3) {
            Product tile = new Product("Tile", new BigDecimal("3.50"), new BigDecimal("4.15"));
            newOrder.setProduct(tile);
        } else if (choice[0] == 4) {
            Product wood = new Product("Wood", new BigDecimal("5.15"), new BigDecimal("4.75"));
            newOrder.setProduct(wood);
        }

    }

    @Override
    public void calculations(Order newOrder) {
        BigDecimal productCost = newOrder.getArea().multiply(newOrder.getProduct().getProductCost());
        BigDecimal laborCost = newOrder.getArea().multiply(newOrder.getProduct().getLaborCostSqFt());
        BigDecimal taxCost = ((productCost.add(laborCost)).multiply(newOrder.getTax().getStateTaxRate().divide(
                new BigDecimal("100")))).setScale(2, RoundingMode.HALF_UP);
        BigDecimal total = productCost.add(laborCost).add(taxCost);

        newOrder.setMaterialCost(productCost);
        newOrder.setLaborCost(laborCost);
        newOrder.setTotalTax(taxCost);
        newOrder.setTotalAmount(total);

    }

    @Override
    public void updateOrder(Order orderToUpdate, LocalDate originalOrderDate) throws PersistenceException{
        
        if (originalOrderDate.compareTo(orderToUpdate.getDate()) == 0) {
            orderDao.editOrder(orderToUpdate);
        } else {
            orderDao.removeOrder(orderToUpdate.getInvoiceID(), originalOrderDate);
            orderDao.addOrder(orderToUpdate, true);
        }

    }

    @Override
    public Order addOrder(Order order, boolean isConfirmed) throws PersistenceException {
        return orderDao.addOrder(order, isConfirmed);
    }

    @Override
    public Order getOrder(int userNum, LocalDate orderDate) throws PersistenceException {
        return orderDao.getOrder(userNum, orderDate);
    }

}
