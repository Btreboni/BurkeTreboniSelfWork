/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.codingchallenge2;

import com.sg.codingchallenge2.view.View;
import com.sg.codingchallenge2.controller.Controller;
import com.sg.codingchallenge2.view.UserIO;
import com.sg.codingchallenge2.view.UserIOImpl;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author admin
 */
public class App {
    public static void main(String[] args) throws UnsupportedEncodingException, IOException{
        
        UserIO io = new UserIOImpl();
        View view = new View(io);
        Controller controller = new Controller(view);
        controller.runProgram();
    }
    
}
