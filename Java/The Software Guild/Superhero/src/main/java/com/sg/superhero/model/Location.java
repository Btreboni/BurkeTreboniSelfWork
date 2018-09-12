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
public class Location {
    
    private int locationId;
    private String locationName;
    private String locationDescription;
    private String locationAddress;
    private double locationLatitude;
    private double locationLongitude;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public double getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(double locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public double getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(double locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.locationId;
        hash = 97 * hash + Objects.hashCode(this.locationName);
        hash = 97 * hash + Objects.hashCode(this.locationDescription);
        hash = 97 * hash + Objects.hashCode(this.locationAddress);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.locationLatitude) 
                ^ (Double.doubleToLongBits(this.locationLatitude) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.locationLongitude) 
                ^ (Double.doubleToLongBits(this.locationLongitude) >>> 32));
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
        final Location other = (Location) obj;
        if (this.locationId != other.locationId) {
            return false;
        }
        if (Double.doubleToLongBits(this.locationLatitude) 
                != Double.doubleToLongBits(other.locationLatitude)) {
            return false;
        }
        if (Double.doubleToLongBits(this.locationLongitude) 
                != Double.doubleToLongBits(other.locationLongitude)) {
            return false;
        }
        if (!Objects.equals(this.locationName, other.locationName)) {
            return false;
        }
        if (!Objects.equals(this.locationDescription, other.locationDescription)) {
            return false;
        }
        if (!Objects.equals(this.locationAddress, other.locationAddress)) {
            return false;
        }
        return true;
    }
    
    
    
}
