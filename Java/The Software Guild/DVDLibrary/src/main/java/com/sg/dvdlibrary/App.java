/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.DVDController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author admin
 */
public class App {
    public static void main(String[] args) {
        
//        UserIO myIO = new UserIOConsoleImpl();
//        DVDView myView = new DVDView(myIO);
//        DVDDao myDao = new DVDDaoFileImpl();
//        DVDLibraryServiceLayer myService = new DVDLibraryServiceLayerImpl(myDao);
//        DVDController myController = new DVDController(myService, myView);
//        myController.run();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DVDController controller = ctx.getBean("controller", DVDController.class);
        controller.run();
        
    }
}
