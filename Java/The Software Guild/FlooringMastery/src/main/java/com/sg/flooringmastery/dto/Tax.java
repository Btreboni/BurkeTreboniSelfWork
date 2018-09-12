/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author admin
 */
public class Tax {

    private String state;
    private BigDecimal stateTaxRate;

    public Tax(String state, BigDecimal stateTaxRate) {
        this.state = state;
        this.stateTaxRate = stateTaxRate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getStateTaxRate() {
        return stateTaxRate;
    }

    public void setStateTaxRate(BigDecimal stateTaxRate) {
        this.stateTaxRate = stateTaxRate;
    }

}
