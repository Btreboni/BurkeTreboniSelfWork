/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

/**
 *
 * @author admin
 */
public class VMDuplicateIDException extends Exception {
    
    public VMDuplicateIDException(String message) {
        super(message);
    }
    
    public VMDuplicateIDException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
    
}
