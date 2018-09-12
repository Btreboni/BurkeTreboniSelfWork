/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.codingchallenge3;

import com.sg.codingchallenge3.controller.Controller;
import com.sg.codingchallenge3.view.UserIO;
import com.sg.codingchallenge3.view.UserIOImpl;
import com.sg.codingchallenge3.view.View;

/**
 *
 * @author admin
 */
public class App {

    public static void main(String[] args) {
        
        UserIO io = new UserIOImpl();
        View view = new View(io);
        Controller controller = new Controller(view);
        controller.runProgram();
    }

}
