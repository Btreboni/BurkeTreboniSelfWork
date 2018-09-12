/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author admin
 */
public class VMVendingDAOImplTest {

    VMVendingDAO dao = new VMVendingDAOImpl();
    Item item = new Item("");

    public VMVendingDAOImplTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws VMPersistenceException {
        //EMPTIES THE FILE
        List<Item> itemlist = dao.listItems();
        for (Item item : itemlist) {
            dao.removeItem(item.getItemId());
        }

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of removeItem method, of class VMVendingDAOImpl.
     */
    @Test
    public void testRemoveItem() throws VMPersistenceException {
        Item newItem = new Item("1");
        newItem.setItemName("Amstel");
        newItem.setPrice(new BigDecimal("3.00"));
        newItem.setQuantity(10);

        dao.addItem(newItem);

        Item newItem2 = new Item("2");
        newItem2.setItemName("Rhinegeist");
        newItem2.setPrice(new BigDecimal("3.25"));
        newItem2.setQuantity(9);

        dao.addItem(newItem2);

        dao.removeItem(newItem.getItemId());
        assertEquals(1, dao.listItems().size());
        assertNull(dao.getItem(newItem.getItemId()));

        dao.removeItem(newItem2.getItemId());
        assertEquals(0, dao.listItems().size());
        assertNull(dao.getItem(newItem2.getItemId()));

    }

    @Test
    public void testAddGetitem() throws Exception {
        Item item = new Item("1");
        item.setItemName("Miller");
        item.setPrice(new BigDecimal("2.50"));
        item.setQuantity(10);
        
        dao.addItem(item);
        Item fromDao = dao.getItem(item.getItemId());
        assertEquals(item, fromDao);
    }
    
     @Test
    public void testGetAllItems() throws Exception {
        Item newItem = new Item("1");
        newItem.setItemName("Amstel");
        newItem.setPrice(new BigDecimal("3.00"));
        newItem.setQuantity(10);

        dao.addItem(newItem);

        Item newItem2 = new Item("2");
        newItem2.setItemName("Rhinegeist");
        newItem2.setPrice(new BigDecimal("3.25"));
        newItem2.setQuantity(9);

        dao.addItem(newItem2);

        assertEquals(2, dao.listItems().size());

    }

}
