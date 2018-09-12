/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.service;

import com.sg.superhero.dao.SuperPowerDao;
import com.sg.superhero.model.Super;
import com.sg.superhero.model.SuperPower;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Burke Treboni
 */
public class SuperPowerServiceImpl implements SuperPowerService {

    SuperPowerDao superPowerDao;

    @Inject
    public SuperPowerServiceImpl(SuperPowerDao superPowerDao) {
        this.superPowerDao = superPowerDao;
    }

    @Override
    public void addSuperPower(SuperPower superPower) {
        superPowerDao.addSuperPower(superPower);
    }

    @Override
    public void deleteSuperPower(int superPowerId) {
        superPowerDao.deleteSuperPower(superPowerId);
    }

    @Override
    public void updateSuperPower(SuperPower superPower) {
        superPowerDao.updateSuperPower(superPower);
    }

    @Override
    public SuperPower getSuperPowerById(int superPowerId) {
        return superPowerDao.getSuperPowerById(superPowerId);
    }

    @Override
    public List<SuperPower> getAllSuperPowers() {
        return superPowerDao.getAllSuperPowers();
    }
    
    @Override
    public List<SuperPower> getSuperPowerbySuper(List<Super> superHuman) {
        List<SuperPower> superPower = new ArrayList();
        superHuman.forEach((hero) -> {
            SuperPower spow = superPowerDao.getSuperPowerById(hero.getSuperId());
            superPower.add(spow);
        });
        
        return superPower;
    }

    @Override
    public SuperPower getSuperPowerBySuperId(Integer superId) {
        return superPowerDao.getSuperPowerBySuperId(superId);
    }

}
