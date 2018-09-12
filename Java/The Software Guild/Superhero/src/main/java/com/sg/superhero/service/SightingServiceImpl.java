/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.service;

import com.sg.superhero.dao.SightingDao;
import com.sg.superhero.model.Location;
import com.sg.superhero.model.Organization;
import com.sg.superhero.model.Sighting;
import com.sg.superhero.model.Super;
import com.sg.superhero.model.SuperHeroSighting;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Burke Treboni
 */
public class SightingServiceImpl implements SightingService {

    SightingDao sightingDao;

    @Inject
    public SightingServiceImpl(SightingDao sightingDao) {
        this.sightingDao = sightingDao;
    }

    @Override
    public void addSighting(Sighting sighting) {
        sightingDao.addSighting(sighting);
    }

    @Override
    public void deleteSighting(int sighting) {
        sightingDao.deleteSighting(sighting);
    }

    @Override
    public void updateSighting(Sighting sighting) {
        sightingDao.updateSighting(sighting);
    }

    @Override
    public Sighting getSightingById(int sightingId) {
        return sightingDao.getSightingById(sightingId);
    }

    @Override
    public List<Sighting> getAllSightings() {
        return sightingDao.getAllSightings();
    }

    @Override
    public List<Sighting> getAllSightingsByLocationId(int locationId) {
        return sightingDao.getAllSightingsByLocation(locationId);
    }

    @Override
    public List<SuperHeroSighting> getAllSightingsByDate() {
        return sightingDao.getAllSightingsByDate();
    }

    @Override
    public Location getLocationBySightingID(int sightingId) {
        return sightingDao.getLocationBySightingID(sightingId);
    }

    @Override
    public Organization getOrganizationBySightingID(int sightingId) {
        return sightingDao.getOrganizationBySightingID(sightingId);
    }

    @Override
    public Super getSuperBySightingID(int sightingId) {
       return sightingDao.getSuperBySightingID(sightingId);
    }
}
