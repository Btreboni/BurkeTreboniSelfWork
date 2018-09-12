/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author admin
 */
public class View {

    UserIO io;

    public View(UserIO io) {
        this.io = io;
    }

    public BigDecimal printMenuSelection(List<Item> itemsList) {
        System.out.println("===== BEER ME VENDING CO. =====");

        for (Item item : itemsList) {

            String itemDetail = item.getItemId() + ": " + item.getItemName() + " $" + item.getPrice();
            io.print(itemDetail);
        }

        return io.readBigDecimal("\nEnter the amount of money \nthat you wish to add, "
                + "\nor enter 0 to go back."
                + "\n===============================");
    }

    public String promptUserMenuItem() {
        return io.readString("Please enter the item number from the above choices.");
    }

    public void printInventoryReadErrorMessage(String errorMessage) {
        io.print(errorMessage);
    }

    public void printMoneyOnScreen(List<Change> changeCoinage) {
        //THINK THIS SHOULD GO IN THE DAO OR SERVICE?
        List<Change> dollars = changeCoinage.stream().filter(c -> Change.DOLLAR == c).collect(Collectors.toList());
        List<Change> quarters = changeCoinage.stream().filter(c -> Change.QUARTER == c).collect(Collectors.toList());
        List<Change> dimes = changeCoinage.stream().filter(c -> Change.DIME == c).collect(Collectors.toList());
        List<Change> nickels = changeCoinage.stream().filter(c -> Change.NICKEL == c).collect(Collectors.toList());
        List<Change> pennies = changeCoinage.stream().filter(c -> Change.PENNY == c).collect(Collectors.toList());

        //print method only accepts strings!
        io.print("");
        io.print("====== Dispensing Change ====== ");
        io.print(dollars.size() + " dollars,");
        io.print(quarters.size() + " quarters, ");
        io.print(dimes.size() + " dimes, ");
        io.print(nickels.size() + " nickels, ");
        io.print(pennies.size() + " pennies. ");
        io.print("===============================");
    }

    public void unknownCommandBanner() {
        io.print("");
        io.print("UNKNOWN COMMAND!!!");
        io.print("");
    }

    public int adminPanel() {
        io.print("===== Admin Panel =====");
        io.print("1. Add Item");
        io.print("2. Remove Item");
        io.print("3. Return To Previous Screen");

        return io.readInt("Please select either Add or Remove an item", 1, 3);
    }

    public int printMenuAndSelection() {
        io.print("===== BEER ME VENDING CO. =====");
        io.print("1. Vend Item");
        io.print("2. Admin Panel");
        io.print("3. Exit Vending Machine");

        return io.readInt("Please select from the above choices.", 1, 3);
    }

    public void displayCreateItemBanner() {
        io.print("");
        io.print("==== Create an item ====");
        io.print("");
    }

    public Item getNewItemInfo() {
        String itemID = io.readString("Please enter the Item ID");
        String itemName = io.readString("Please enter the Item Name");
        BigDecimal price = io.readBigDecimal("Please enter the Item Price");
        Integer quantity = io.readInt("Please enter the Item Quantity");
        Item currentItem = new Item(itemID);
        currentItem.setItemName(itemName);
        currentItem.setPrice(price);
        currentItem.setQuantity(quantity);
        return currentItem;
}
    
    public void displayCreateItemSuccessBanner() {
        io.print("Your item has been successfully created!");
    }
    
    public void displayErrorMessage(Exception errorMessage) {
        io.print("An Error Occured");
        io.print(errorMessage.getMessage());
    }
    
    public void displayRemoveItemBanner() {
        io.print("");
        io.print("=== Remove Item ===");
        io.print("");
    }
    
    public void displayRemovedItemSuccessBanner() {
        io.print("");
        io.print("Item successfully removed. Please hit enter to continue");
        io.print("");
    }
    
    public String getItemIDChoice() {
        return io.readString("Please enter the Item ID");
    }
    
    public void thankYouBanner() {
        io.print("Thank you for choosing Beer Me Vending Co.");
        io.print("Have a great day!");
    }

}
