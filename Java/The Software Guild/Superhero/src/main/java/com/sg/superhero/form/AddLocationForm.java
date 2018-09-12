/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.form;

import java.util.Objects;

/**
 *
 * @author Burke Treboni
 */
public class AddLocationForm {
    
    private Integer locationId;
    private String locationName;
    private String locationDescription;
    private String locationAddress;
    private double locationLatitude;
    private double locationlongitude;

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
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

    public double getLocationlongitude() {
        return locationlongitude;
    }

    public void setLocationlongitude(double locationlongitude) {
        this.locationlongitude = locationlongitude;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.locationId);
        hash = 67 * hash + Objects.hashCode(this.locationName);
        hash = 67 * hash + Objects.hashCode(this.locationDescription);
        hash = 67 * hash + Objects.hashCode(this.locationAddress);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.locationLatitude) ^ (Double.doubleToLongBits(this.locationLatitude) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.locationlongitude) ^ (Double.doubleToLongBits(this.locationlongitude) >>> 32));
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
        final AddLocationForm other = (AddLocationForm) obj;
        if (Double.doubleToLongBits(this.locationLatitude) != Double.doubleToLongBits(other.locationLatitude)) {
            return false;
        }
        if (Double.doubleToLongBits(this.locationlongitude) != Double.doubleToLongBits(other.locationlongitude)) {
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
        if (!Objects.equals(this.locationId, other.locationId)) {
            return false;
        }
        return true;
    }
    
    
}
