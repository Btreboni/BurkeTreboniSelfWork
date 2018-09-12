/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.controller;

import com.sg.flooringmastery.dto.Operations;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.ui.View;
import java.time.LocalDate;
import com.sg.flooringmastery.service.OrderService;
import com.sg.flooringmastery.service.PersistenceException;
import java.util.List;
import javax.xml.bind.ValidationException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author admin
 */
public class FMController implements ApplicationContextAware {
    //NEED TO DEFINE INTERFACE MEANING!

    View view;
    OrderService service;
    Operations myOps;
    ApplicationContext applicationContext;
    OrderService trainingService;
    OrderService configuredService;

    public FMController(View view,
            OrderService service, OrderService trainingService) {
        this.view = view;
        this.service = service;
        this.trainingService = trainingService;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        
        menuTrainProd();

        while (keepGoing) {

            
            menuSelection = getMenuSelection();

            switch (menuSelection) {

                case 1:
                    displayOrder();
                    break;
                case 2:
                    addOrder();
                    break;
                case 3:
                    editOrder();
                    break;
                case 4:
                    removeOrder();
                    break;
                case 5:
                    savedWork();
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuSelection();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitbanner();
    }

    private void addOrder() {

        try {
            view.displayAddOrderBanner();
            Order newOrder = view.getNewOrderInfo();
            int[] productTaxChoices = view.getProductTaxesChoices();
            service.setProductTaxes(newOrder, productTaxChoices);
            service.calculations(newOrder);
            view.printOrderDetails(newOrder);
            boolean isConfirmed = view.getConfirmation();
            service.addOrderNumber(newOrder);
            configuredService.addOrder(newOrder, isConfirmed);
            view.displayAddOrderSuccessbanner(isConfirmed);
        } catch (Exception e) {
            view.displayErrorMessage(e);
        }

    }

    private void displayOrder() {

        try {
            view.displayOrdersBanner();
            LocalDate getDate = view.getLocalDate();
            List<Order> displayOrder = configuredService.getOrdersList(getDate);
            if (displayOrder.size() != 0) {
                //display orders via view class
                view.displayAllOrdersForDate(displayOrder);
            } else {
                //display data validation error message
                throw new ValidationException("Sorry, there are no Orders for that Date");
            }
        } catch (PersistenceException | ValidationException e) {
        }

    }

    private void editOrder() {

        //Prompt user for date and order number
        //If order exists, ask the user for each piece of order data but display
        // the existing data.
        //It the user enters something new, replace the data. If enter is hit,
        // existing data will stay in place. 
        boolean continueLoop = true;
        try {
            view.displayEditOrder();
            LocalDate orderDate = view.getLocalDate();
            int userNum = view.getEditID();
            while (continueLoop) {
                //SEND TO SERVICE
                Order orderToUpdate = service.getOrder(userNum, orderDate);
                if (orderToUpdate != null) {
                    view.getEditLocalDate(orderToUpdate);
                    view.getEditCustomerName(orderToUpdate);
                    view.getEditArea(orderToUpdate);

                    int[] material = view.getEditProductType();
                    if (material != null) {
                        service.setProductTaxes(orderToUpdate, material);
                    }
                    service.calculations(orderToUpdate);
                    configuredService.updateOrder(orderToUpdate, orderDate);
                    continueLoop = false;
                } else {

                    continueLoop = false;
                }
            }

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        view.displayEditSuccessBanner();
    }

    private void removeOrder() {
        try {
            view.displayRemoveOrderBanner();
            LocalDate removeDate = view.removeDateChoice();
            Integer removeOrder = view.removeInvoiceIdChoice();
            configuredService.removeOrder(removeOrder, removeDate);
            view.displayRemoveOrderSuccessBanner();
        } catch (Exception e) {
            view.displayErrorMessage(e);
        }
    }

    private void displayOperationsChoice() {
        int opChoice = view.promptTrainProd();
        if (opChoice == 1) {
            myOps = Operations.TRAINING;
        } else if (opChoice == 2) {
            myOps = Operations.PRODUCTION;
        } else {
            view.displayErrorMessage(
                    new ValidationException("Sorry, that is not a valid selection"));
        }

    }

    private void configureServiceLayer() {
        if (myOps == Operations.TRAINING) {
            configuredService = trainingService;
        } else if (myOps == Operations.PRODUCTION) {
            configuredService = service;
        }
    }
    
    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        //SPRING CONTEXT AWARE APPLICATION INTERFACE
        this.applicationContext = ac;
    }

    public void savedWork() {
        view.save();
        view.saveSuccess();
    }

    private void menuTrainProd() {
        view.displayHello();
        displayOperationsChoice();
        configureServiceLayer();
    }

}
