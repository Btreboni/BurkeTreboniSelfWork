/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.service;

import com.sg.superhero.dao.SuperSightingDao;
import com.sg.superhero.model.SuperSighting;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Burke Treboni
 */
public class SuperSightingServiceImpl implements SuperSightingService {

    SuperSightingDao superSightingDao;

    @Inject
    public SuperSightingServiceImpl(SuperSightingDao superSightingDao) {
        this.superSightingDao = superSightingDao;
    }

    @Override
    public void addSuperSighting(SuperSighting superSighting) {
        superSightingDao.addSuperSighting(superSighting);
    }

    @Override
    public void deleteSuperSighting(int superSightingId) {
        superSightingDao.deleteSuperSighting(superSightingId);
    }

    @Override
    public void updateSuperSighting(SuperSighting superSighting) {
        superSightingDao.updateSuperSighting(superSighting);
    }

    @Override
    public SuperSighting getSuperSightingById(int superSightingId) {
        return superSightingDao.getSuperSightingById(superSightingId);
    }

    @Override
    public List<SuperSighting> getAllSuperSightings() {
        return superSightingDao.getAllSuperSightings();
    }

    @Override
    public SuperSighting getSuperSightingBySightingId(int sightingId) {
        return superSightingDao.getSuperSightingBySightingId(sightingId);
    }

}
