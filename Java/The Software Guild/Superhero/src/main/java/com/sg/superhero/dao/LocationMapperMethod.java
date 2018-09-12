/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.model.Location;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Burke Treboni
 */
public class LocationMapperMethod {
    
    protected static final class LocationMapper implements RowMapper<Location> {

        @Override
        public Location mapRow(ResultSet rs, int i) throws SQLException {
            Location loc = new Location();
            loc.setLocationId(rs.getInt("locationId"));
            loc.setLocationName(rs.getString("locationName"));
            loc.setLocationDescription(rs.getString("locationDescription"));
            loc.setLocationAddress(rs.getString("locationAddress"));
            loc.setLocationLatitude(rs.getDouble("locationLatitude"));
            loc.setLocationLongitude(rs.getDouble("locationLongitude"));
            return loc;
        }
        
    }
}
