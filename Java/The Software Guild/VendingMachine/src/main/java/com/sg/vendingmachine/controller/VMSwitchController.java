/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VMPersistenceException;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.InsufficientFundsException;
import com.sg.vendingmachine.service.NoItemInventoryException;
import com.sg.vendingmachine.service.VMService;
import com.sg.vendingmachine.ui.View;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author admin
 */
public class VMSwitchController {
    
    private VMService service;
    private View view;
    
    public VMSwitchController(VMService service, View view) {
        this.service = service;
        this.view = view;
        ;
        
    }
    
    public void runSwitch() {
        boolean keepGoing = true;
        int menuSelection = 0;
        
        while (keepGoing) {
            
            menuSelection = firstPrintMenu();
            
            switch (menuSelection) {
                
                case 1:
                    runWhile();
                    break;
                
                case 2:
                    adminSwitch();
                    break;
                
                case 3:
                    keepGoing = false;
                    break;
                
                default:
                    unknownCommand();
            }
        }
        goodbye();
        
    }
    
    private void goodbye() {
        view.thankYouBanner();
    }
    
    private void unknownCommand() {
        view.unknownCommandBanner();
    }
    
    private void admin() {
        view.adminPanel();
    }
    
    private void adminSwitch() {
        boolean continueGoing = true;
        int myMenuSelection = 0;
        
        while (continueGoing) {            
            
            myMenuSelection = getSecondMenuSelection();
            
            switch (myMenuSelection) {
                
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    continueGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
    }
    
    private int getSecondMenuSelection() {
        return view.adminPanel();
    }
    
    private void addItem() {
        try {
            view.displayCreateItemBanner();
            Item newItem = view.getNewItemInfo();
            service.addItem(newItem);
            view.displayCreateItemSuccessBanner();
        } catch (Exception e) {
            view.displayErrorMessage(e);
        }
    }
    
    private void runWhile() {
        
        boolean keepGoing = true;
        
        while (keepGoing) {
            
            try {
                BigDecimal zeroMoney = new BigDecimal("0");
                BigDecimal userMoney = getMenuSelection();
                System.out.println();
                //NEED TO ADD || USERMONEY < ZERO MONEY
                if (userMoney.equals(zeroMoney)) {
                    keepGoing = false;
                } else {
                    String selectedItem = view.promptUserMenuItem();
                    
                    Item newItem = service.vendItem(selectedItem, userMoney);
                    List<Change> newList = service.calculateChange(newItem, userMoney);
                    view.printMoneyOnScreen(newList);
                }
                
            } catch (VMPersistenceException | NoItemInventoryException
                    | InsufficientFundsException ex) {
                view.printInventoryReadErrorMessage(ex.getMessage());
            }
            
        }
        
    }
    
    private BigDecimal getMenuSelection() throws VMPersistenceException {
        List<Item> itemList = service.listItems();
        return view.printMenuSelection(itemList);
    }
    
    private int firstPrintMenu() {
        return view.printMenuAndSelection();
    }
    
    private void removeItem() {
        try {
            view.displayRemoveItemBanner();
            String removeItem = view.getItemIDChoice();
            service.removeItem(removeItem);
            view.displayRemovedItemSuccessBanner();
        } catch (Exception e) {
            view.displayErrorMessage(e);
        }
    }
    
}
