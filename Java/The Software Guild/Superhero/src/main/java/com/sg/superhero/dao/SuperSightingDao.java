/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.model.SuperSighting;
import java.util.List;

/**
 *
 * @author Burke Treboni
 */
public interface SuperSightingDao {

    public void addSuperSighting(SuperSighting superSighting);

    public void deleteSuperSighting(int superSightingId);

    public void updateSuperSighting(SuperSighting superSighting);

    public SuperSighting getSuperSightingById(int superSightingId);

    public List<SuperSighting> getAllSuperSightings();
    
    public SuperSighting getSuperSightingBySightingId(int sightingId);
   
}
