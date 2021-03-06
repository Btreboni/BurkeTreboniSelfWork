/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;


import com.sg.superhero.model.Super;
import com.sg.superhero.model.SuperOrganization;
import java.util.List;

/**
 *
 * @author Burke Treboni
 */
public interface SuperOrganizationDao {

    public void addSuperOrganization(SuperOrganization superOrganization);

    public void deleteSuperOrganization(int superId);

    public void updateSuperOrganization(SuperOrganization superOrganization);

    public SuperOrganization getSuperOrganizationById(int superOrganizationId);

    public List<SuperOrganization> getAllSuperOrganizations();
    
    public SuperOrganization getSuperOrganizationBySuperId(int superId);
}
