/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.service;

import com.sg.superhero.dao.SuperDao;
import com.sg.superhero.model.Super;
import com.sg.superhero.model.SuperHeroOrgList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Burke Treboni
 */
public class SuperServiceImpl implements SuperService {

    SuperDao superDao;

    @Inject
    public SuperServiceImpl(SuperDao superDao) {
        this.superDao = superDao;
    }

    @Override
    public void addSuper(Super superP) {
        superDao.addSuper(superP);
    }

    @Override
    public void deleteSuper(int superId) {
        superDao.deleteSuper(superId);
    }

    @Override
    public void updateSuper(Super superP) {
        superDao.updateSuper(superP);
    }

    @Override
    public Super getSuperById(int superId) {
        return superDao.getSuperById(superId);
    }

    @Override
    public List<Super> getAllSupers() {
        return superDao.getAllSupers();
    }

    @Override
    public List<Super> getAllLocationsBySuperId(int locationid) {
        return superDao.getAllSuperByLocationId(locationid);
    }

    @Override
    public List<Super> getAllSuperByOrganization(int organizationId) {
        return superDao.getAllSuperByOrganization(organizationId);
    }

    @Override
    public List<SuperHeroOrgList> loadSuperHeros() {
        return superDao.loadSuperHeros();
    }



}
