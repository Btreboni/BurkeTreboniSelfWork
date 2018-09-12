/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.model.SuperHeroSighting;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author admin
 */
public class SuperHeroSightingMapper implements RowMapper<SuperHeroSighting> {

    @Override
    public SuperHeroSighting mapRow(ResultSet rs, int i) throws SQLException {
        
        SuperHeroSighting shs = new SuperHeroSighting();
        shs.setSightingId(rs.getInt("sightingId"));
        shs.setSightingDate(rs.getDate("sightingDate").toLocalDate());
        shs.setSuperName(rs.getString("superName"));
        shs.setLocationName(rs.getString("locationName"));
        shs.setOrganizationName(rs.getString("organizationName"));
        
        return shs;        
    }
}
