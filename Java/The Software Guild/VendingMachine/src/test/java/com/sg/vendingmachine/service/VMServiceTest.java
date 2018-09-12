/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
public class VMServiceTest {
    
    VMServiceImpl service;
    
    public VMServiceTest() {
//        ClassRosterDao dao = new ClassRosterDaoStubImpl();
//        ClassRosterAuditDao auditDao = new ClassRosterAuditDaoStubImpl();
//
//        //Initialize our service member variable
//        service = new ClassRosterServiceLayerImpl(dao, auditDao);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("service", VMServiceImpl.class);

    }
    
//    VMAuditDao auditDao = new VMAuditDaoStubImpl();
//    VMVendingDAO dao = new VMVendingDaoStubImpl();
//    VMService service = new VMServiceImpl(dao, auditDao);

//    public VMServiceImplTest() {
//        this.dao = dao;
//        this.auditDao = auditDao;
//    }

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
     * Test of vendItem method, of class VMServiceImpl.
     */
    @Test
    public void testAddItem() throws Exception {
        Item newItem = new Item("2");
        newItem.setItemName("Select");
        newItem.setPrice(new BigDecimal("3.00"));
        newItem.setQuantity(10);
        
        service.addItem(newItem);
    }

    /**
     * Test of calculateChange method, of class VMServiceImpl.
     */
    @Test
    public void testCalculateChange() {
        List<Change> myList = new ArrayList();
        myList.add(Change.DOLLAR);
        myList.add(Change.QUARTER);
        myList.add(Change.DOLLAR);
        myList.add(Change.NICKEL);
        myList.add(Change.DOLLAR);
    }

}
