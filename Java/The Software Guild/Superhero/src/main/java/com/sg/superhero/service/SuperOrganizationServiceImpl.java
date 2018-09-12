/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.service;

import com.sg.superhero.dao.SuperOrganizationDao;
import com.sg.superhero.model.SuperOrganization;
import java.util.List;
import javax.inject.Inject;

/**
 * @author Burke Treboni
 */
public class SuperOrganizationServiceImpl implements SuperOrganizationService {

    SuperOrganizationDao superOrganizationDao;

    @Inject
    public SuperOrganizationServiceImpl(SuperOrganizationDao superOrganizationDao) {
        this.superOrganizationDao = superOrganizationDao;
    }

    @Override
    public void addSuperOrganization(SuperOrganization superOrganization) {
        superOrganizationDao.addSuperOrganization(superOrganization);
    }

    @Override
    public void deleteSuperOrganization(int superId) {
        superOrganizationDao.deleteSuperOrganization(superId);
    }

    @Override
    public void updateSuperOrganization(SuperOrganization superOrganization) {
        superOrganizationDao.updateSuperOrganization(superOrganization);
    }

    @Override
    public SuperOrganization getSuperOrganizationById(int superOrganizationId) {
        return superOrganizationDao.getSuperOrganizationById(superOrganizationId);
    }

    @Override
    public List<SuperOrganization> getAllSuperOrganizations() {
        return superOrganizationDao.getAllSuperOrganizations();
    }

    @Override
    public SuperOrganization getSuperOrganizationBySuperId(int superId) {
        return superOrganizationDao.getSuperOrganizationBySuperId(superId);
    }
}
