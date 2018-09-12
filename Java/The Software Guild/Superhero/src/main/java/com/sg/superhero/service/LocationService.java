/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.service;

import com.sg.superhero.model.Location;
import java.util.List;

/**
 *
 * @author Burke Treboni
 */
public interface LocationService {

    public void addLocation(Location location);
    
    public void deleteLocation(int locationId);
    
    public void updateLocation(Location location);
    
    public Location getLocationById(int locationId);
    
    public List<Location> getAllLocations(); 
    
    public List<Location> getAllLocationsBySuperId(int superId);
}
