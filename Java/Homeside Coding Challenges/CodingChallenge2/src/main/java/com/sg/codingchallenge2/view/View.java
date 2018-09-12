/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.codingchallenge2.view;

/**
 *
 * @author admin
 */
public class View {

    UserIO io;

    public View(UserIO io) {
        this.io = io;
    }

    public void helloMessage() {
        System.out.println("Hello! Welcome to Homeside Text Service!");
        System.out.println("");
    }

    public String phoneNumberPrompt() {
        return io.readString("Enter the Phone number that "
                + "you would like to send your message to. "
                + "\nUse a 10 digit number (EX: 614-799-2660)");

    }

    public String messagePrompt() {
        return io.readString("Please enter the message you would like to send.");
    }

    public void displayMessageAndNumber(String prompt1, String prompt2) {
        io.print("You entered: " + prompt1 + " | " + prompt2);
        io.print("");
        io.print("Your text was sent!");
    }

    public int printMenuSelection() {
        io.print("==== Homeside Texting Service ====");
        io.print("1. Send new text message");
        io.print("2. Exit Program");
        io.print("");

        return io.readInt("Please select from the above choices.", 1, 2);
    }

    public void goodbye() {
        System.out.println("Goodbye!");
    }

    public void unknownCommandBanner() {
        io.print("");
        io.print("UNKNOWN COMMAND!!!");
        io.print("");
    }

    //Text message error handling
    public void textTooLong() {
        io.print("Sorry, Your text was longer than 20 characters. Please try again");
    }
    
    //Phone number error handling
    public void phoneNumberErrorMessage() {
        io.print("Sorry, your phone number must be 10 digits long. Please try again.");
    }
    
    //Phone number error handling
    public void textMessageErrorMessage() {
        io.print("Please enter numbers only for a phone number!");
    }
}
