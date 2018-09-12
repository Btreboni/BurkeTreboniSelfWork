/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery;

import com.sg.flooringmastery.controller.FMController;
import com.sg.flooringmastery.dao.FMOrderDao;
import com.sg.flooringmastery.dao.FMOrderDaoImpl;
import com.sg.flooringmastery.service.OrderService;
import com.sg.flooringmastery.service.TrainingServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 * @author admin
 */
public class App {
    public static void main(String[] args) {
        
//        UserIO io = new UserIOImpl();
//        View view = new View(io);
//        FMOrderDao dao = new FMOrderDaoImpl();
//        FMOrderNumberDao numDao = new FMOrderNumberDaoImpl();
//        FMAuditOrderDao auditDao = new FMAuditOrderDaoFileImpl();
//        OrderService service = new OrderServiceImpl(dao, numDao, auditDao);
//        OrderService trainService = new TrainingServiceImpl(dao);
//        FMController controller = new FMController(view, service);
//        controller.run();
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        FMController controller = ctx.getBean("controller", FMController.class);
        controller.run();
    }
}
