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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author admin
 */
public class SightingMapperMethod {

    protected static final class SightingMapper implements RowMapper<Sighting> {

        @Override
        public Sighting mapRow(ResultSet rs, int i) throws SQLException {

            Location loc = new Location();
            loc.setLocationId(rs.getInt("locationId"));
            
            Sighting s = new Sighting();
            s.setSightingId(rs.getInt("sightingId"));
            s.setSightingDate(rs.getDate("sightingDate").toLocalDate());
            s.setLocation(loc);
            return s;
        }
    }
    
    protected static final class SightingDateMapper implements RowMapper<Sighting> {

        @Override
        public Sighting mapRow(ResultSet rs, int i) throws SQLException {
            
//            SuperPower sp = new SuperPower();
//            sp.setSuperPowerId(rs.getInt("superPowerId"));
//            sp.setSuperPowerName(rs.getString("superPowerName"));
            
            Super sup = new Super();
            sup.setSuperName(rs.getString("superName"));
            
            Location loc = new Location();
            loc.setLocationName(rs.getString("locationName"));
            
            
            Sighting s = new Sighting();
            s.setSightingId(rs.getInt("sightingId"));
            s.setSightingDate(rs.getDate("sightingDate").toLocalDate());
            s.setLocation(loc);
            
            return s;
        }
    
    }
}
