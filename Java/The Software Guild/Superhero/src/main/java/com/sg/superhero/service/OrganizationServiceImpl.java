/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.service;

import com.sg.superhero.dao.OrganizationDao;
import com.sg.superhero.model.Organization;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Burke Treboni
 */
public class OrganizationServiceImpl implements OrganizationService {

    OrganizationDao organizationDao;

    @Inject
    public OrganizationServiceImpl(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }

    @Override
    public void addOrganization(Organization organization) {
        organizationDao.addOrganization(organization);
    }

    @Override
    public void deleteOrganization(int organizationId) {
        organizationDao.deleteOrganization(organizationId);
    }

    @Override
    public void updateOrganization(Organization organization) {
        organizationDao.updateOrganization(organization);
    }

    @Override
    public Organization getOrganizationById(int organizationId) {
        return organizationDao.getOrganizationById(organizationId);
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return organizationDao.getAllOrganizations();
    }

    @Override
    public List<Organization> getAllOrganizationsBySuper(int superId) {
        return organizationDao.getAllOrganizationsBySuper(superId);
    }

}
