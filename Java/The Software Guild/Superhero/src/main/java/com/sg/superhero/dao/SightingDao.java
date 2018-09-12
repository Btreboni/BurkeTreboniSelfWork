/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.model.Location;
import com.sg.superhero.model.Organization;
import com.sg.superhero.model.Sighting;
import com.sg.superhero.model.Super;
import com.sg.superhero.model.SuperHeroSighting;
import java.util.List;

/**
 *
 * @author Burke Treboni
 */
public interface SightingDao {

    public void addSighting(Sighting sighting);

    public void deleteSighting(int sighting);

    public void updateSighting(Sighting sighting);

    public Sighting getSightingById(int sightingId);
    
    public List<Sighting> getAllSightings();
    
    public List<Sighting> getAllSightingsByLocation(int locationId);
    
    public Location findLocationOfSighting(Sighting sighting);
    
    public List<Super> findSuperAtSighting(Sighting sighting);
    
    public Location getLocationBySightingID(int sightingId);
    
    public Organization getOrganizationBySightingID(int sightingId);
    
    public Super getSuperBySightingID(int sightingId);
    
    public List<Sighting> displayLocationSupersAndSightings(List<Sighting> sightingList);
    
    public List<SuperHeroSighting> getAllSightingsByDate();
}
