/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.model.Location;
import com.sg.superhero.model.Organization;
import com.sg.superhero.model.Sighting;
import com.sg.superhero.model.Super;
import com.sg.superhero.model.SuperSighting;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Burke Treboni
 */
public class SuperSightingMapperMethod {
    
    protected static final class SuperSightingMapper 
            implements RowMapper<SuperSighting> {

        @Override
        public SuperSighting mapRow(ResultSet rs, int i) throws SQLException {
            SuperSighting superSighting = new SuperSighting();
            superSighting.setSuperSightingId(rs.getInt("superSightingId"));
            
            Super s = new Super();
            s.setSuperId(rs.getInt("superId"));
            superSighting.setSuperHuman(s);
            
            Sighting si = new Sighting();
            si.setSightingId(rs.getInt("sightingId"));
            superSighting.setSighting(si);

            
            return superSighting;
        }
    }
}
