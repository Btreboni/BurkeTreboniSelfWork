/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author admin
 */
public enum Change {
    
    DOLLAR(new BigDecimal("1.00"), "Dollar"),
    QUARTER(new BigDecimal("0.25"), "Quarter"),
    DIME(new BigDecimal("0.10"), "Dime"),
    NICKEL(new BigDecimal("0.05"), "Nickel"),
    PENNY(new BigDecimal("0.01"), "Penny");

    private final BigDecimal changeValue;
    private final String displayValue;

    Change(BigDecimal changeValue, String displayValue) {
        this.changeValue = changeValue;
        this.displayValue = displayValue;
    }

    public BigDecimal getChangeValue() {
        return changeValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
    
}
