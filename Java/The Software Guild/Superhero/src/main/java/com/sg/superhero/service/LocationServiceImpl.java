/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.service;

import com.sg.superhero.dao.LocationDao;
import com.sg.superhero.model.Location;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Burke Treboni
 */
public class LocationServiceImpl implements LocationService {

    LocationDao locationDao;

    @Inject
    public LocationServiceImpl(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    @Override
    public void addLocation(Location location) {
        locationDao.addLocation(location);
    }

    @Override
    public void deleteLocation(int locationId) {
        locationDao.deleteLocation(locationId);
    }

    @Override
    public void updateLocation(Location location) {
        locationDao.updateLocation(location);
    }

    @Override
    public Location getLocationById(int locationId) {
        return locationDao.getLocationById(locationId);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationDao.getAllLocations();
    }

    @Override
    public List<Location> getAllLocationsBySuperId(int superId) {
        return locationDao.getAllLocationsBySuperId(superId);
    }



}
