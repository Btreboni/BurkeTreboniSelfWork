/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.PortableInterceptor.SUCCESSFUL;

/**
 *
 * @author admin
 */
public class VMVendingDAOImpl implements VMVendingDAO {

    private static final String VENDING_MACHINE_FILE = "Inventory.txt";
    private static final String DELIMITER = "::";
    private static final String VENDING_MACHINE_FILE_TEMP = "InventoryTemp.txt";

    @Override
    public List<Item> listItems() throws VMPersistenceException {

        Scanner scan = new Scanner(System.in);
        List<Item> myList = new ArrayList();

        try {
            scan = new Scanner(new BufferedReader(new FileReader(VENDING_MACHINE_FILE)));

        } catch (FileNotFoundException e) {
            throw new VMPersistenceException("Uh Oh... "
                    + "could not load items into inventory", e);
        }
        String currentLine;
        String[] currentTokens;

        while (scan.hasNextLine()) {

            currentLine = scan.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Item currentItem = new Item(currentTokens[0]);
            currentItem.setItemName(currentTokens[1]);
            currentItem.setPrice(new BigDecimal(currentTokens[2]));
            currentItem.setQuantity(new Integer(currentTokens[3]));

            myList.add(currentItem);
        }
        scan.close();

        return myList;

    }

    @Override
    public Item getItem(String itemId) throws VMPersistenceException {
        List<Item> allItems = listItems();

        for (Item item : allItems) {
            if (item.getItemId().equals(itemId)) {
                return item;
            }
        }

        return null;
    }

    @Override
    public void updateItem(Item itemToUpdate) throws VMPersistenceException {
        try {
            File inputFile = new File(VENDING_MACHINE_FILE);
            File tempFile = new File(VENDING_MACHINE_FILE_TEMP);

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String itemIdIndicator = itemToUpdate.getItemId() + DELIMITER;
                if (!currentLine.startsWith(itemIdIndicator)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                } else {
                    writer.write(itemToUpdate.toString() + System.getProperty("line.separator"));
                }
            }

            writer.close();
            reader.close();
            boolean successful = tempFile.renameTo(inputFile);

        } catch (IOException ex) {
            throw new VMPersistenceException("An error occurred while updating an item", ex);
        }
    }

    @Override
    public Item addItem(Item item) throws VMPersistenceException {
        PrintWriter writer;

        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(VENDING_MACHINE_FILE, true)));
            writer.println(item.toString());
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(VMVendingDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }

    @Override
    public Item removeItem(String itemID) throws VMPersistenceException {
        File inputFile = new File(VENDING_MACHINE_FILE);
        File tempFile = new File(VENDING_MACHINE_FILE_TEMP);

        Item itemToRemove = getItem(itemID);

        try {

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            //I DO THIS IN THE ADD ITEM, WHICH IS WHY IT ADDS THE WHOLE ITEM
            // writer.println(item.toString());
            while ((currentLine = reader.readLine()) != null) {
                String itemIndicator = itemToRemove.getItemId() + "::";
                if (!currentLine.startsWith(itemIndicator)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.close();
            reader.close();
            boolean successful = tempFile.renameTo(inputFile);
        } catch (IOException ex) {
            Logger.getLogger(VMVendingDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itemToRemove;
    }

}
