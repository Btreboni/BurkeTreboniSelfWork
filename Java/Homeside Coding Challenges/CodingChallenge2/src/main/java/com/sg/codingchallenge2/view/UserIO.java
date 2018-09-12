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
public interface UserIO {
    
    public void print(String message);
    
    int readInt(String prompt, int min, int max);
    
    public String readString(String prompt);
    
    public int readInt(String prompt);
}
