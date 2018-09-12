/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import com.sg.flooringmastery.service.PersistenceException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author admin
 */
public class FMOrderDaoTest {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    FMOrderDao orderDao = new FMOrderDaoImpl();
    Order order = new Order();

    public FMOrderDaoTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws PersistenceException {
//        LocalDate ld = new LocalDate();
//        
//        List<Order> orderList = orderDao.getListOfOrder();
//        for (Order order1 : orderList) {
//            orderDao.removeOrder(order.getInvoiceID(), order1.getDate());
//        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGenerateOrderFileName() throws PersistenceException {
        //EXPECTING THIS METHOD TO GENERATE FILENAMES THAT WE WANT/EXPECT.
        LocalDate testDate = LocalDate.parse("06/06/2017", formatter);
        String generateFileName = orderDao.generateOrderFileName(testDate);
        String testFileName = FMOrderDaoImpl.FILENAME_PREFIX + "06062017"
                + FMOrderDaoImpl.FILE_EXTENSTION;
        Assert.assertEquals(testFileName, generateFileName);
    }

    @Test
    public void testTempGenerateOrderFileName() throws PersistenceException {
        //THIS TEST IS THE SAME AS ABOVE, BUT WILL INSTEAD BE TESTING THE TEMP
        // SIDE OF THE PROGRAM RATHER THAN THE PROD.
        LocalDate testDate = LocalDate.parse("06/07/2017", formatter);
        String generateFileName = orderDao.generateTempOrderFileName(testDate);
        String testFileName = FMOrderDaoImpl.FILENAME_PREFIX_TEMP + "06072017"
                + FMOrderDaoImpl.FILE_EXTENSTION;
        Assert.assertEquals(testFileName, generateFileName);
    }

    @Test
    public void testRemoveOrder() throws PersistenceException {
        
        Order newOrder = new Order();
        newOrder.setInvoiceID(1);
        newOrder.setCustomerName("Yogis");
        newOrder.setTax(new Tax("OH", new BigDecimal("4.25")));
        newOrder.setArea(new BigDecimal("500"));
        newOrder.setProduct(new Product("Tile", new BigDecimal("5.00"), new BigDecimal("3.12")));
        newOrder.setMaterialCost(new BigDecimal("3.25"));
        newOrder.setLaborCost(new BigDecimal("700"));
        newOrder.setTotalTax(new BigDecimal(64.21));
        newOrder.setTotalAmount(new BigDecimal("1023.20"));
        newOrder.setDate(LocalDate.parse("01012001", DateTimeFormatter.ofPattern("MMddyyyy")));
        
        orderDao.addOrder(newOrder, true);

        Order newOrder2 = new Order();
        newOrder2.setInvoiceID(2);
        newOrder2.setCustomerName("Novaks");
        newOrder2.setTax(new Tax("OH", new BigDecimal("4.25")));
        newOrder2.setArea(new BigDecimal("600"));
        newOrder2.setProduct(new Product("Carpet", new BigDecimal("4.00"), new BigDecimal("2.12")));
        newOrder2.setMaterialCost(new BigDecimal("3.25"));
        newOrder2.setLaborCost(new BigDecimal("600"));
        newOrder2.setTotalTax(new BigDecimal(44.21));
        newOrder2.setTotalAmount(new BigDecimal("923.20"));
        newOrder2.setDate(LocalDate.parse("01032001", DateTimeFormatter.ofPattern("MMddyyyy")));
        
        orderDao.addOrder(newOrder2, true);
        
        orderDao.removeOrder(1, newOrder.getDate());
        assertEquals(1, orderDao.getListOfOrder(newOrder.getDate()).size());
        assertNull(orderDao.generateOrderFileName(newOrder.getDate()));
        
        orderDao.removeOrder(2, newOrder.getDate());
        assertEquals(0, orderDao.getListOfOrder(newOrder2.getDate()).size());
        assertNull(orderDao.generateOrderFileName(newOrder2.getDate()));
    }
    
    @Test
    public void testListOrder() {
    
    }
    
    @Test 
    public void testEditOrder() {
    
    }
    
    @Test 
    public void testGetOrder() {
    
    }

    @Test
    public void testAddOrder() {

    }
}
