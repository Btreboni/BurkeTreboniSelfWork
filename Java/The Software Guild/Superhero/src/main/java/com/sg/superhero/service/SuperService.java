/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.service;

import com.sg.superhero.model.Super;
import com.sg.superhero.model.SuperHeroOrgList;
import java.util.List;

/**
 *
 * @author Burke Treboni
 */
public interface SuperService {

    public void addSuper(Super superP);

    public void deleteSuper(int superId);

    public void updateSuper(Super superP);

    public Super getSuperById(int superId);

    public List<Super> getAllSupers();
    
    public List<Super> getAllLocationsBySuperId(int locationid);
    
    public List<Super> getAllSuperByOrganization(int organizationId);
    
    public List<SuperHeroOrgList> loadSuperHeros();
}
