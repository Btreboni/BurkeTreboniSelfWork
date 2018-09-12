/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class UserIOConsoleImpl implements UserIO { 
    
    private final Scanner scan = new Scanner(System.in);
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        String userInput = scan.nextLine();
        double userNum = Integer.parseInt(userInput);
        
        return userNum;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {

        boolean userNumOutOfRange = true;
        double userNum;
        
        do {
            System.out.println(prompt);
            String userInput = scan.nextLine();
            userNum = Double.parseDouble(userInput);
            
            if (userNum >= min && userNum <= max) {
                userNumOutOfRange = false;
            }
            
        } while (userNumOutOfRange);
        
        return userNum;
    }

    @Override
    public float readFloat(String prompt) {
        
        System.out.println(prompt);
        String userInput = scan.nextLine();
        float userNum = Integer.parseInt(userInput);
        
        return userNum;
        
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        boolean userKNumOutOfRange = true;        
        float userNum;
        
        do {
            System.out.println(prompt);
            String userInput = scan.nextLine();
            userNum = Float.parseFloat(userInput);
            
            if (userNum >= min && userNum <= max) {
                userKNumOutOfRange = false;
            }
            
        } while (userKNumOutOfRange);
        
        return userNum;
        

    }

    @Override
    public int readInt(String prompt) {
        
        System.out.print(prompt);
        String userInput = scan.nextLine();
        int userNum =Integer.parseInt(userInput);
        return userNum;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
       
        boolean userNumOutOfRange = true;
        
        int userNum;
        
        do {
            System.out.println(prompt);
            String userInput = scan.nextLine();
            userNum = Integer.parseInt(userInput);
            
            if (userNum >= min && userNum <= max) {
                userNumOutOfRange = false;
            }    
                
        } while (userNumOutOfRange);
        
        return userNum;
        
    }

    @Override
    public long readLong(String prompt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String userInput = scan.nextLine();
        
        return userInput; 
        
    }

    @Override
    public LocalDate readLocalDate(String prompt, String errorMessage) {
        String userInput;
        System.out.println(prompt);
        userInput = scan.nextLine();
        LocalDate ld;
        
        try {
            ld = LocalDate.parse(userInput, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        } catch (Exception e) {
            System.out.println(errorMessage);
            userInput = scan.nextLine();
            ld = LocalDate.parse(userInput, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        }
        return ld;
    }
    
    
    

    
}
