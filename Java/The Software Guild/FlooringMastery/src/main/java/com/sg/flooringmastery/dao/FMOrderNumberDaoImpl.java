/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.service.PersistenceException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class FMOrderNumberDaoImpl implements FMOrderNumberDao {

    public int loadOrderNumber() throws PersistenceException {
        Scanner scan = null;
        String fileName = ("OrderNum.txt");//Name of file to contain order
        try {
            //ADD LOCAL DATE TIME STAMP HERE
            scan = new Scanner(new BufferedReader(new FileReader((fileName))));
        } catch (FileNotFoundException e) {
        }
        String currentLine;
        currentLine = scan.nextLine();
        int orderNumber = Integer.parseInt(currentLine);
        orderNumber++;

        scan.close();
        return orderNumber;
    }

    @Override
    public void saveOrderNumber(int orderNum) throws PersistenceException {
        try {
            PrintWriter writer;

            File orderNumFile = new File("OrderNum.txt");

            writer = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(orderNumFile)));

            writer.println(orderNum);
            writer.close();
        } catch (IOException e) {
            //ERROR MESSAGE
        }
    }
}
