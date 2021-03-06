/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.model.SuperPower;
import java.util.List;

/**
 *
 * @author Burke Treboni
 */
public interface SuperPowerDao {

    public void addSuperPower(SuperPower superPower);

    public void deleteSuperPower(int superPowerId);

    public void updateSuperPower(SuperPower superPower);

    public SuperPower getSuperPowerById(int superPowerId);

    public List<SuperPower> getAllSuperPowers();
    
    public SuperPower getSuperPowerBySuperId(Integer superId);
}
