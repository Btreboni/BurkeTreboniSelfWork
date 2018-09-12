/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dto.Order;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author admin
 */
public class OrderServiceTest {
    
    OrderService orderService;

    public OrderServiceTest() {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    orderService  = ctx.getBean("orderService", OrderServiceImpl.class);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of removeOrder method, of class OrderService.
     * @throws java.lang.Exception
     */
    
    @Test
    public void testCalculations(Order newOrder) throws Exception {
        
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
    
    @Test
    public void testRemoveOrder() throws Exception {

    }

    /**
     * Test of addOrderNumber method, of class OrderService.
     */
    @Test
    public void testAddOrderNumber() throws Exception {

    }

    /**
     * Test of getOrdersList method, of class OrderService.
     */
    @Test
    public void testGetOrdersList() throws Exception {

    }

    /**
     * Test of setProductTaxes method, of class OrderService.
     */
    @Test
    public void testSetProductTaxes() throws Exception {

    }

    /**
     * Test of calculations method, of class OrderService.
     */  

    /**
     * Test of updateOrder method, of class OrderService.
     */
    @Test
    public void testUpdateOrder() throws Exception {

    }

    /**
     * Test of addOrder method, of class OrderService.
     */
    @Test
    public void testAddOrder() throws Exception {

    }

    /**
     * Test of getOrder method, of class OrderService.
     */
    @Test
    public void testGetOrder() throws Exception {
        
    }

}
