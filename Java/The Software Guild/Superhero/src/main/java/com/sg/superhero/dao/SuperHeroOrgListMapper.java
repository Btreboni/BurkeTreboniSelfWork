/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.model.SuperHeroOrgList;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author admin
 */
public class SuperHeroOrgListMapper implements RowMapper<SuperHeroOrgList> {

    @Override
    public SuperHeroOrgList mapRow(ResultSet rs, int i) throws SQLException {
        
        SuperHeroOrgList shol = new SuperHeroOrgList();
        shol.setSuperId(rs.getInt("superId"));
        shol.setSuperPowerId(rs.getInt("superPowerId"));
        shol.setSuperName(rs.getString("superName"));
        shol.setSuperDescription(rs.getString("superDescription"));
        shol.setSuperPowerName(rs.getString("superPowerName"));
        shol.setOrganizationName(rs.getString("organizationName"));
        
        return shol;
    }
    
}
