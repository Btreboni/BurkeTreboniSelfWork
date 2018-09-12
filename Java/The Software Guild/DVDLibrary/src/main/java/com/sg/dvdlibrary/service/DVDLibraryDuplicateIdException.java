/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

/**
 *
 * @author admin
 */
public class DVDLibraryDuplicateIdException extends Exception {
    
    //Adding our two different type of constructors.
    //One will take a string method able to take a string message, so if something
    //goes wrong we can input a message
    //
    //Another also takes a message but also take a throwable cause. 
    
    public DVDLibraryDuplicateIdException(String message) {
        super(message);
    }
    
    public DVDLibraryDuplicateIdException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
