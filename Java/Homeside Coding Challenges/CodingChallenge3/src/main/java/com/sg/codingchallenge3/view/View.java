/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.codingchallenge3.view;

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
        io.print("");
        io.print("Hello! Welcome to Homeside Production Assistant!");
        io.print("");
    }

    public int printMenuSelection() {
        io.print("==== Homeside Production Assistant ====");
        io.print("1. New Production Analyzation");
        io.print("2. Exit Program");
        io.print("");

        return io.readInt("Please select from the above choices.", 1, 2);
    }

    public void goodbye() {
        io.print("");
        io.print("Thank you for using Homeside Production Assistant!");
        io.print("");
        io.print("Goodbye!");
    }

    public void unknownCommandBanner() {
        io.print("");
        io.print("UNKNOWN COMMAND!!!");
        io.print("");
    }

    public void spacing() {
        io.print("");
    }

    public String csvTitlePrompt() {
        return io.readString("Enter the CSV Title Path (do not include .csv): ");
    }

    public void csvError() {
        io.print("");
        io.print("Your path cannot have '.csv' in the path name");
        io.print("");
        io.print("Please try again!");
    }

    public String newTXTDocumentNamePrompt() {
        io.print("");
        return io.readString("Label the new Total Production File "
                + "(EX: 2017 Total Production), DO NOT include .txt!: ");
    }

    public void txtError() {
        io.print("");
        io.print("Your path cannot have '.txt' in the path name");
        io.print("");
        io.print("Please try again!");
    }
    
    public void succesfullCreation (String str) {
        io.print(str + " has been successfully created!");
    }

    public void processSuccessMessage(String str) {
       io.print(str + " has been processed without any errors!");
    }

    public void fileErrorBanner(String fileIN) {
        io.print("There was an error caught while attempting to process: "
                            + fileIN);
    }

    public void sqlConfirmationMessage(String fileOUT) {
        io.print(fileOUT + " loaded to MYSQL");
    }

    public void sqlErrorMessage(String fileOUT) {
        io.print(fileOUT + " NOT loaded to MYSQL-----ERROR");
    }
}
