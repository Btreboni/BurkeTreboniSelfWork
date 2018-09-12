/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.model;

import java.util.Objects;

/**
 *
 * @author Burke Treboni
 */
public class SuperOrganization {
    
    private int superOrganizationId;
    private Super superHuman;
    private Organization organization;

    public int getSuperOrganizationId() {
        return superOrganizationId;
    }

    public void setSuperOrganizationId(int superOrganizationId) {
        this.superOrganizationId = superOrganizationId;
    }

    public Super getSuperHuman() {
        return superHuman;
    }

    public void setSuperHuman(Super superHuman) {
        this.superHuman = superHuman;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.superOrganizationId;
        hash = 89 * hash + Objects.hashCode(this.superHuman);
        hash = 89 * hash + Objects.hashCode(this.organization);
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
        final SuperOrganization other = (SuperOrganization) obj;
        if (this.superOrganizationId != other.superOrganizationId) {
            return false;
        }
        if (!Objects.equals(this.superHuman, other.superHuman)) {
            return false;
        }
        if (!Objects.equals(this.organization, other.organization)) {
            return false;
        }
        return true;
    }
}
