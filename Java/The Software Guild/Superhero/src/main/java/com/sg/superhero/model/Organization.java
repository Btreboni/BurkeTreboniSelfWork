/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.model;

import java.util.Objects;

/**
 *
 * @author admin
 */
public class Organization {
    
    private int organizationId;
    private String organizationName;
    private String organizationDescription;
    private String organizationAddress;
    private String organizationPhone;
    private String organizationEmail;

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationDescription() {
        return organizationDescription;
    }

    public void setOrganizationDescription(String organizationDescription) {
        this.organizationDescription = organizationDescription;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }

    public String getOrganizationPhone() {
        return organizationPhone;
    }

    public void setOrganizationPhone(String organizationPhone) {
        this.organizationPhone = organizationPhone;
    }

    public String getOrganizationEmail() {
        return organizationEmail;
    }

    public void setOrganizationEmail(String organizationEmail) {
        this.organizationEmail = organizationEmail;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.organizationId;
        hash = 83 * hash + Objects.hashCode(this.organizationName);
        hash = 83 * hash + Objects.hashCode(this.organizationDescription);
        hash = 83 * hash + Objects.hashCode(this.organizationAddress);
        hash = 83 * hash + Objects.hashCode(this.organizationPhone);
        hash = 83 * hash + Objects.hashCode(this.organizationEmail);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Organization other = (Organization) obj;
        if (this.organizationId != other.organizationId) {
            return false;
        }
        if (!Objects.equals(this.organizationName, 
                other.organizationName)) {
            return false;
        }
        if (!Objects.equals(this.organizationDescription, 
                other.organizationDescription)) {
            return false;
        }
        if (!Objects.equals(this.organizationAddress, 
                other.organizationAddress)) {
            return false;
        }
        if (!Objects.equals(this.organizationPhone, 
                other.organizationPhone)) {
            return false;
        }
        if (!Objects.equals(this.organizationEmail, 
                other.organizationEmail)) {
            return false;
        }
        return true;
    }
    
    
}
