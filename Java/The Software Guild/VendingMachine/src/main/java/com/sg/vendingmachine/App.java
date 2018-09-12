/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine;

import com.sg.vendingmachine.controller.VMSwitchController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author admin
 */
public class App {

    public static void main(String[] args) {

//        UserIO myIo = new UserIOImpl();
//        View myView = new View(myIo);
//        VMVendingDAO myDao = new VMVendingDAOImpl();
//        VMAuditDao myAuditDao = new VMAuditDaoFileImpl();
//        VMService myService = new VMServiceImpl(myDao, myAuditDao);
//        VMSwitchController controller = new VMSwitchController(myService, myView);
//        controller.runSwitch();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        VMSwitchController controller = ctx.getBean("controller", VMSwitchController.class);
        controller.runSwitch();
    }
}
