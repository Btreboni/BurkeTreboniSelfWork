/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import com.sg.flooringmastery.dto.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author admin
 */
public class View {

    UserIO io;

    public View(UserIO io) {
        this.io = io;
    }

    public int printMenuSelection() {
        io.print("========================================");
        io.print("========================================");
        io.print("====== Columbus Flooring Company =======");
        io.print("========================================");
        io.print("===_________________________________====");
        io.print("===|  [1] Display an Order By Date |====");
        io.print("===|  [2] Add an Order             |====");
        io.print("===|  [3] Edit an Existing Order   |====");
        io.print("===|  [4] Remove an Existing Order |====");
        io.print("===|  [5] Save Current Work        |====");
        io.print("===|  [6] Exit                     |====");
        io.print("===|_______________________________|====");
        io.print("========================================");
        io.print("========================================");
        io.print("========================================");
        

        return io.readInt("Please Select from the above choices.", 1, 6);
    }

    public void displayUnknownCommandBanner() {
        io.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        io.print("!!!!!!!!!!!UNKNOWN COMMAND!!!!!!!!!!!!!!");
        io.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    public void displayExitbanner() {
        io.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        io.print("!!!!!!!!!!!!!!GOOD BYE!!!!!!!!!!!!!!!!!!");
        io.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    public int[] getProductTaxesChoices() {
        int[] stateProductChoices = new int[2];
        //THIS IS GOING TO NEED RE-DONE.
        //YOU NEED TO FILL IN THE VARIABLE OPTIONS INSTEAD OF A STRING MESSAGE

        stateProductChoices[0]
                = io.readInt("Enter the type of material\n[1]Carpet, [2]Laminate, [3]Tile, [4]Wood", 1, 4);
        stateProductChoices[1]
                = io.readInt("Which state is this order for [1]OH, [2]PA, [3]MI, or [4]IN", 1, 4);

        return stateProductChoices;
    }

    public Order getNewOrderInfo() {
        LocalDate date = io.readLocalDate("Enter the Date of the Order in MM/DD/YYYY");
        String customerName = io.readString("Enter the customer Name or Business");
        BigDecimal area = io.readBigDecimal("Enter the area needed [SqFt]");

        Order currentOrder = new Order();
        currentOrder.setDate(date);
        currentOrder.setCustomerName(customerName);
        currentOrder.setArea(area);

        return currentOrder;

    }

    public void displayAddOrderBanner() {
        io.print("========================================");
        io.print("=========== Create New Order ===========");
        io.print("========================================");
    }

    public void displayAddOrderSuccessbanner(boolean isConfirmed) {
        isConfirmed = true;
        if (isConfirmed) {
            io.print("");
            io.print("Your order has been submitted!");
            io.readString("Press ENTER to continue");
        } else {
            io.print("");
            io.print("Your order has been removed!");
            io.readString("Press ENTER to continue");
        }
    }

    public void displayErrorMessage(Exception errorMessage) {
        io.print("\nAn Error Occured");
        io.print(errorMessage.getMessage());
        errorMessage.printStackTrace();
    }

    public void displayOrdersBanner() {
        io.print("========================================");
        io.print("=============== Orders =================");
        io.print("========================================");
    }

    public void displayRemoveOrderBanner() {
        io.print("========================================");
        io.print("=========== Remove an Order ============");
        io.print("========================================");
    }

    public void displayRemoveOrderSuccessBanner() {
        io.print("========================================");
        io.print("= Order has been successfully removed =");
        io.print("========================================");
    }

    public void displayEditOrder() {
        io.print("========================================");
        io.print("============= Edit Order ===============");
        io.print("========================================");
    }

    public void displayEditSuccessBanner() {
        io.print("========================================");
        io.print("== Order has been successfully edited ==");
        io.print("========================================");
    }

    public void displaySaveOrderBanner() {
        io.print("========================================");
        io.print("============== Save Order ==============");
        io.print("========================================");
    }

    public void displaySaveOrderSuccessBanner() {
        io.print("=========================================");
        io.print("=== Order has been successfully saved ===");
        io.print("=========================================");
        
    }

    public int removeInvoiceIdChoice() {
        return io.readInt("Please enter the Invoice ID you would like to remove ");
    }

    public LocalDate removeDateChoice() {
        return io.readLocalDate("Please enter the Date MM/DD/YYYY "
                + "that you would like to remove");
    }

    public void printOrderDetails(Order newOrder) {
        io.print("========================================");
        io.print("============= Order Details ============");
        io.print("========================================");
        if (newOrder.getInvoiceID() != 0) {
            io.print("Order ID: " + newOrder.getInvoiceID());
        }
        
        io.print("========================================");
        io.print("==| Name: " + newOrder.getCustomerName());
        io.print("==| State: " + newOrder.getTax().getState());
        io.print("==| Tax Rate: " 
                + newOrder.getTax().getStateTaxRate() + "%");
        io.print("==| Product: " + newOrder.getProduct().getProductName()); 
        io.print("==| Area: " + newOrder.getArea() + "ft^2");
        io.print("==| Cost Per Square Foot: $" 
                + newOrder.getProduct().getProductCost());
        io.print("==| Labor Cost Per Square Foot: $" 
                + newOrder.getProduct().getLaborCostSqFt());
        io.print("==| Material Cost: $" 
                + newOrder.getMaterialCost());
        io.print("==| Labor Cost: $" + newOrder.getLaborCost());
        io.print("==| Tax: $" + newOrder.getTotalTax());
        io.print("==| Total: $" + newOrder.getTotalAmount());
        io.print("========================================");
        io.print("========================================");
    }

    public boolean getConfirmation() {
        io.print("========================================");
        io.print("========================================");
        io.print("===___________________________________==");
        io.print("==|        Is order Correct?         |==");
        io.print("==|       [1] YES - ADD order        |==");
        io.print("==|       [2] NO  - DELETE order     |==");
        io.print("==|__________________________________|==");
        io.print("========================================");
        io.print("========================================");
        io.print("========================================");
        return io.getConfirmation("SELECTION:");
    }

    public LocalDate getLocalDate() {
        return io.readLocalDate("Enter the order date that you would like to edit"
                + " in the format MM/DD/YYYY");
    }

    public int getEditID() {
        return io.readInt("Enter the Order ID that you would like to edit");
    }

    public void getEditLocalDate(Order orderToEdit) {
        String date
                = io.readString("Enter the new order date in the form of MM/DD/YYYY");
        if (!date.equals("")) {
            try {
                LocalDate newDate
                        = LocalDate.parse(date, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                orderToEdit.setDate(newDate);
            } catch (Exception e) {
                io.readLocalDate("Date invalid. Please enter a valid date 'MM/DD/YYYY'");
            }
        }
    }

    public void getEditCustomerName(Order orderToEdit) {
        String name
                = io.readString("Enter the new Customer Name ");
        if (!name.equals("")) {
            orderToEdit.setCustomerName(name);
        }
    }

    public void getEditArea(Order orderToEdit) {
        String area = io.readString("Enter the new Square Footage (Area) ");
        if (!area.equals("")) {
            try {
                BigDecimal newArea = new BigDecimal(area);
                orderToEdit.setArea(newArea);
            } catch (Exception e) {
                io.readString("Area invalid. Please enter a valid number for Area");
            }
        }
    }

    public int[] getEditProductType() {
        int[] stateProductChoices = new int[2];
        stateProductChoices[0]
                = io.readInt("Enter the type of material\n[1]Carpet, [2]Laminate, [3]Tile, [4]Wood", 1, 4);
        stateProductChoices[1]
                = io.readInt("Which state is this order for \n[1]OH, [2]PA, [3]MI, or [4]IN", 1, 4);

        return stateProductChoices;
    }

    public void displayAllOrdersForDate(List<Order> displayOrders) {
        for (Order order : displayOrders) {
            io.print("Invoice ID#: " + order.getInvoiceID()
                    + "\nCustomer Name: " + order.getCustomerName()
                    + "\nState: " + order.getTax().getState()
                    + "\nState Tax Rate: " + order.getTax().getStateTaxRate() + "%"
                    + "\nArea : " + order.getArea()
                    + "\nProduct Type: " + order.getProduct().getProductName()
                    + "\nProduct Cost: $" + order.getProduct().getProductCost()
                    + "\nLabor Cost per SqFt: $" + order.getProduct().getLaborCostSqFt()
                    + "\nMaterial Cost: $" + order.getMaterialCost()
                    + "\nLabor Cost Total: $" + order.getLaborCost()
                    + "\nTotal Tax: $" + order.getTotalTax()
                    + "\nTotal Amount: $" + order.getTotalAmount()
                    + "\n=============================================");
            
        }
        io.readString("Please hit enter to continue");
    }

    public void displayContinueMessage() {
        io.readString("");
        io.readString("Please hit enter to continue");
    }
    
    public int promptTrainProd(){
        
        io.print("Please select with mode you would like");
        io.print("[1] Training \n[2] Production");
        int userInput = io.readInt("");
        io.readString("Press ENTER to conitinue");
        
        return userInput;
    }
    
    public void save() {
        io.print("Would you like to Save your work?");
        io.print("[1] Yes or [2] No ");
        
    }
    
    public void saveSuccess() {
        io.print("Your orders have been save sucessfully!");
        io.readString("Press ENTER to continue");
    }

    public void displayHello() {
        io.print("========================================");
        io.print("========================================");
        io.print("====== Columbus Flooring Company =======");
        io.print("========================================");
        io.print("========================================");
    }
}
