/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import static com.sg.superhero.dao.PreparedStatements.SQL_SELECT_ALL_ORGANIZATION_BY_SUPER;
import com.sg.superhero.model.Organization;
import com.sg.superhero.model.SuperOrganization;
import java.util.List;

/**
 *
 * @author Burke Treboni
 */
public interface OrganizationDao {

    public void addOrganization(Organization organization);

    public void deleteOrganization(int organizationId);

    public void updateOrganization(Organization organization);

    public Organization getOrganizationById(int organizationId);

    public List<Organization> getAllOrganizations();
    
    public List<Organization> getAllOrganizationsBySuper(int superId);
}
