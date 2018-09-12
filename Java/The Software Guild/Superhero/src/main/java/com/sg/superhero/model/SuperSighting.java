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
public class SuperSighting {
    
    private int superSightingId;
    private Super superHuman;
    private Sighting sighting;

    public SuperSighting() {
    }

    public int getSuperSightingId() {
        return superSightingId;
    }

    public void setSuperSightingId(int superSightingId) {
        this.superSightingId = superSightingId;
    }

    public Super getSuperHuman() {
        return superHuman;
    }

    public void setSuperHuman(Super superHuman) {
        this.superHuman = superHuman;
    }

    public Sighting getSighting() {
        return sighting;
    }

    public void setSighting(Sighting sighting) {
        this.sighting = sighting;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.superSightingId;
        hash = 53 * hash + Objects.hashCode(this.superHuman);
        hash = 53 * hash + Objects.hashCode(this.sighting);
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
        final SuperSighting other = (SuperSighting) obj;
        if (this.superSightingId != other.superSightingId) {
            return false;
        }
        if (!Objects.equals(this.superHuman, other.superHuman)) {
            return false;
        }
        if (!Objects.equals(this.sighting, other.sighting)) {
            return false;
        }
        return true;
    }

    
}