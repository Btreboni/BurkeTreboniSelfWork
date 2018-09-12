/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VMAuditDao;
import com.sg.vendingmachine.dao.VMDataValidationException;
import com.sg.vendingmachine.dao.VMDuplicateIDException;
import com.sg.vendingmachine.dao.VMPersistenceException;
import com.sg.vendingmachine.dao.VMVendingDAO;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class VMServiceImpl implements VMService {

    private VMVendingDAO dao;
    private VMAuditDao auditDao;

    private static final Integer ITEM_VENDING_QUANITY = 1;

    public VMServiceImpl(VMVendingDAO dao, VMAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public Item vendItem(String itemId, BigDecimal userDough)
            throws VMPersistenceException, InsufficientFundsException, NoItemInventoryException {
        Item itemToVend = dao.getItem(itemId);
        BigDecimal itemPrice = itemToVend.getPrice();
        Integer itemQuantity = itemToVend.getQuantity();

        if (itemQuantity.equals(0)) {
            throw new NoItemInventoryException("Sorry, we are currently out of Item " + itemId);
        }

        if (itemPrice.compareTo(userDough) == 1) {
            //COMPARETO RETURNS 1, -1, OR ZERO FOR >, <, OR =.
            //IF ITEMPRICE > USER$, SENDS ERROR.
            //System.out.println("$" + userDough);
            throw new InsufficientFundsException("\nSorry, you do not have enough money to purchase item: "
                    + itemId + " \nYou have: $" + userDough + " in the machine." + "\n");

        }

        itemToVend.setQuantity(itemQuantity - ITEM_VENDING_QUANITY);
        dao.updateItem(itemToVend);

        return itemToVend;
    }

    @Override
    public List<Change> calculateChange(Item itemToVend, BigDecimal userDough) {
        BigDecimal itemPrice = itemToVend.getPrice();
        BigDecimal changeNeeded = userDough.subtract(itemPrice);
        BigDecimal changeIssued = new BigDecimal("0.00");

        List<Change> changeCoinage = new ArrayList();
        boolean moreCoinsAreNeeded = true;

        while (moreCoinsAreNeeded) {

            if (isDenominationSmallEnoughToAdd(changeIssued, changeNeeded, Change.DOLLAR)) {
                changeCoinage.add(Change.DOLLAR);
                changeIssued = changeIssued.add(Change.DOLLAR.getChangeValue());

            } else if (isDenominationSmallEnoughToAdd(changeIssued, changeNeeded, Change.QUARTER)) {
                changeCoinage.add(Change.QUARTER);
                changeIssued = changeIssued.add(Change.QUARTER.getChangeValue());

            } else if (isDenominationSmallEnoughToAdd(changeIssued, changeNeeded, Change.DIME)) {
                changeCoinage.add(Change.DIME);
                changeIssued = changeIssued.add(Change.DIME.getChangeValue());

            } else if (isDenominationSmallEnoughToAdd(changeIssued, changeNeeded, Change.NICKEL)) {
                changeCoinage.add(Change.NICKEL);
                changeIssued = changeIssued.add(Change.NICKEL.getChangeValue());

            } else if (isDenominationSmallEnoughToAdd(changeIssued, changeNeeded, Change.PENNY)) {
                changeCoinage.add(Change.PENNY);
                changeIssued = changeIssued.add(Change.PENNY.getChangeValue());

            } else {
                moreCoinsAreNeeded = false;
                //LOOPS UNTIL YOU DON'T OWE ANY MORE CHANGE
            }
        }

        return changeCoinage;
    }

    // Comparison Value is equal to the change issued (big decimal 0.00) adding
    //the denomination of the change value. Then it returns this compared to
    //the change that is needed to satisfy the change required if it is less than
    // 1, aka is less than the change required. 
    private boolean isDenominationSmallEnoughToAdd(BigDecimal changeIssued, BigDecimal changeNeeded, Change denomination) {
        BigDecimal comparisonValue = changeIssued.add(denomination.getChangeValue());
        return comparisonValue.compareTo(changeNeeded) < 1;
        //AGAIN, COMPARETO -1,1,0 AN  <,>,= 0.
    }

    @Override
    public List<Item> listItems() throws VMPersistenceException {
        return dao.listItems();
    }

    @Override
    public void addItem(Item item) throws VMPersistenceException,
            VMDataValidationException, VMDuplicateIDException {
        if (dao.getItem(item.getItemId()) != null) {
            throw new VMDuplicateIDException("ERROR: COULD NOT CREATE ITEM. ITEM NAME "
                    + item.getItemName() + "ALREADY EXISTS.");
        }

        //MUST VALIDATE THAT THE ITEM DATA IS OKAY
        validateItemData(item);
        dao.addItem(item);

        //auditDao.writeAuditEntry("Item" + item.getItemId() + " : " + item.getItemName() + " CREATED." );
    }

    @Override
    public void removeItem(String itemId) throws VMPersistenceException {
        //auditDao.writeAuditEntry("Item " + itemId + " : " + item.getItemName() + " REMOVED." );
        dao.removeItem(itemId);

    }

    private void validateItemData(Item item) throws VMDataValidationException {
        //MAKING SURE THAT NONE OF THE FIELDS ARE NULL OR EMPTY
        if (item.getItemId() == null || item.getItemId().trim().length() == 0
                || item.getItemName() == null || item.getItemName().trim().length() == 0
                || item.getPrice().equals(null) || item.getPrice().equals(0)) {
            throw new VMDataValidationException("ERROR: ALL FIELDS "
                    + "[ITEM ID, ITEM NAME, ITEM PRICE] ARE REQUIRED");

        }

    }

}
