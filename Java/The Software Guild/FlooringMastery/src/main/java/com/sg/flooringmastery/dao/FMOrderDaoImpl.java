/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.service.PersistenceException;
import com.sg.flooringmastery.dto.Tax;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author admin
 */
public class FMOrderDaoImpl implements FMOrderDao {

    public static final String FILENAME_PREFIX = "Order_";
    public static final String FILENAME_PREFIX_TEMP = "Order_Temp_";
    public static final String FILE_EXTENSTION = ".txt";
    public static final String DELIMITER = ", ";

    public static int orderNum;
    private Scanner scan = new Scanner(System.in);
    
    FMAuditOrderDao auditDao;

    public FMOrderDaoImpl() {

    }

    @Override
    public Order addOrder(Order order, boolean isConfirmed) throws PersistenceException {

        if (isConfirmed) {
            //TESTING!! DELETE THE FILE AND MAKE SURE IT CREATES FROM SCRATCH
            try {
                PrintWriter writer;
                String genFile = generateOrderFileName(order.getDate());

                File newFile = new File(genFile);

                if (newFile.exists()) {
                    writer = new PrintWriter(
                            new BufferedWriter(
                                    new FileWriter(genFile, true)));

                } else {
                    writer = new PrintWriter(
                            new BufferedWriter(
                                    new FileWriter(genFile)));
                    writer.println(""
                            + "Invoice ID# || "
                            + "Customer Name || "
                            + "State || "
                            + "State Tax Rate || "
                            + "Area (SqFt) || "
                            + "Product Type || "
                            + "Product Cost || "
                            + "Labor Cost Per SqFt || "
                            + "Material Cost ||"
                            + "Labor Cost Total || "
                            + "Total Tax || "
                            + "Total Amount ||");
                }
                writer.println(order.toString());
                writer.close();
            } catch (IOException e) {
                //ERROR MESSAGE
            }
        }
        return order;

    }

    @Override
    public List<Order> getListOfOrder(LocalDate date) throws PersistenceException {
        //Step 1: create new list variable that contaions type Order.
        //Step 2; create a Sting variable FileName that contains type 
        //        String(use the generateOrderFilenameMethod)
        //Step 3: Read order data out of each line of the file for each order (Scaner,Reader)
        //Step 4: Add each line to the List
        //Step 5: Return list
        //STep 6: TEST!

        List<Order> myList = new ArrayList<>();//Add orders into
        Scanner scan;
        String fileName = generateOrderFileName(date);//Name of file to contain order
        try {
            scan = new Scanner(new BufferedReader(new FileReader(fileName)));

            String currentLine;
            String[] currentTokens;
            int counter = 0;

            while (scan.hasNextLine()) {
                currentLine = scan.nextLine();

                if (counter != 0) {
                    currentTokens = currentLine.split(DELIMITER);

                    Order currentOrder = new Order();
                    currentOrder.setInvoiceID(new Integer(currentTokens[0]));
                    currentOrder.setCustomerName(currentTokens[1]);
                    currentOrder.setTax(new Tax(currentTokens[2],
                            new BigDecimal(currentTokens[3])));
                    currentOrder.setArea(new BigDecimal(currentTokens[4]));
                    currentOrder.setProduct(new Product(currentTokens[5],
                            new BigDecimal(currentTokens[6]),
                            new BigDecimal(currentTokens[7])));
                    currentOrder.setMaterialCost(new BigDecimal(currentTokens[8]));
                    currentOrder.setLaborCost(new BigDecimal(currentTokens[9]));
                    currentOrder.setTotalTax(new BigDecimal(currentTokens[10]));
                    currentOrder.setTotalAmount(new BigDecimal(currentTokens[11]));
                    currentOrder.setDate(date);

                    myList.add(currentOrder);
                }
                counter++;
            }
            scan.close();
        } catch (FileNotFoundException | NumberFormatException ex) {
            //ERROR MESSAGE HERE
        }
        return myList;
    }

    @Override
    public void editOrder(Order order) throws PersistenceException {

        try {
            File inputFile = new File(generateOrderFileName(order.getDate()));
            File tempFile = new File(generateTempOrderFileName(order.getDate()));

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            //DON'T SPECIFY DATE BECAUSE IT'S ALREADY IN THE FILENAME

            while ((currentLine = reader.readLine()) != null) {
                String orderDateIndicator = order.getInvoiceID() + DELIMITER;
                if (!currentLine.startsWith(orderDateIndicator)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                } else {
                    writer.write(order.toString() + System.getProperty("line.separator"));
                }
            }

            writer.close();
            reader.close();
            boolean successful = tempFile.renameTo(inputFile);
        } catch (IOException | NumberFormatException ex) {
            //Throw in an ErrorMessage
        }
    }

    @Override
    public void removeOrder(int invoiceID, LocalDate date) throws PersistenceException {
        try {

            File inputFile = new File(generateOrderFileName(date));
            File tempFile = new File(generateTempOrderFileName(date));

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String orderIndicator = invoiceID + DELIMITER;
                if (!currentLine.startsWith(orderIndicator)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.close();
            reader.close();
            boolean successful = tempFile.renameTo(inputFile);

            //CLEARING THE EMPTY FILE
            List<Order> remainingOrders = getListOfOrder(date);
            if (remainingOrders.size() == 0) {
                inputFile.delete();
            }

        } catch (IOException | NumberFormatException ex) {
            //EXCEPTION ERROR MESSAGE HERE
        }

    }

    @Override
    public String generateOrderFileName(LocalDate date) throws PersistenceException {
        //    ALL THIS METHOD DOES REALLY, IS TURNS A DATE INTO A FILENAME
        // 1. CALLING A STATIC METHOD DEFINED WHITHIN DATETIMEFORMATTER, THIS IS
        //    STATING THE PATTERN THAT THE DATE MUST FOLLOW. 
        // 2. THE OFPATTERN RETURNS A NEW INSTANCE OF THE DATETIMEFORMATTER
        //
        // 3. RETURNING THE CONSTANT VARIABLE FNPREFIX (ORDER_) + USERINPUT DATE 
        //    + FILEEXT(.TXT). THIS CREATES THE NEW FILES. 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        String formattedDate = formatter.format(date);
        return FILENAME_PREFIX + formattedDate + FILE_EXTENSTION;

    }

    @Override
    public String generateTempOrderFileName(LocalDate date) throws PersistenceException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        String formattedDate = formatter.format(date);
        return FILENAME_PREFIX_TEMP + formattedDate + FILE_EXTENSTION;
    }

    @Override
    public Order getOrder(Integer invoiceID, LocalDate date) throws PersistenceException {
        List<Order> newList = getListOfOrder(date);
        //Goes into newlist, and filters out any order that doesn't match the invoice ID Variable.
        List<Order> filteredList
                = newList
                        .stream()
                        .filter(o -> o.getInvoiceID() == invoiceID)
                        .collect(Collectors.toList());
        if (filteredList.size() == 1) {
            return filteredList.get(0);

        } else {
            throw new PersistenceException(
                    "Too many results found for Invoice ID and Date provided.");
        }
    }

}



