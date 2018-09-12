/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author admin
 */
public class Order {

    private int invoiceID = 0;
    private LocalDate date;
    private String customerName;
    private Product product;
    private Tax tax;
    private BigDecimal area;
    private BigDecimal taxAmount;
    private BigDecimal totalAmount;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal totalTax;

    public String TOKEN = ", ";

    public Order() {
        
    }

    public Order(LocalDate date, String customerName, Product productType, Tax tax, BigDecimal area, BigDecimal taxAmount, BigDecimal totalAmount, BigDecimal materialCost, BigDecimal laborCost, BigDecimal totalTax) {
        this.date = date;
        this.customerName = customerName;
        this.product = productType;
        this.tax = tax;
        this.area = area;        
        this.taxAmount = taxAmount;
        this.totalAmount = totalAmount;
        this.materialCost = materialCost;
        this.laborCost = laborCost;
        this.totalTax = totalTax;
    }
    
    

    public String toString() {
        return invoiceID 
                + TOKEN + customerName 
                + TOKEN + tax.getState() 
                + TOKEN + tax.getStateTaxRate()
                + TOKEN + area
                + TOKEN + product.getProductName()
                + TOKEN + product.getProductCost() 
                + TOKEN + product.getLaborCostSqFt() 
                + TOKEN + materialCost 
                + TOKEN + laborCost 
                + TOKEN + totalTax 
                + TOKEN + totalAmount;
    }
    
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getTOKEN() {
        return TOKEN;
    }

    public void setTOKEN(String TOKEN) {
        this.TOKEN = TOKEN;
    }  

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }

}
