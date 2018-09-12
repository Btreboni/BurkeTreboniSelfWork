/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.model.Location;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import static com.sg.superhero.dao.LocationMapperMethod.*;
import static com.sg.superhero.dao.PreparedStatements.*;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 *
 * @author Burke Treboni
 */
public class LocationDaoImpl implements LocationDao {

    //JdbcTemplate injection
    private JdbcTemplate jdbcTemplate;

    //constructor injection
    @Inject
    public LocationDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*
    Need the @Transactional annotation when inserting new location data into the
    database because i'm taking two seperate actions in the addLocation method-
    first insert a new row into the location table and ask SQL for the value
    of the auto_increment LocationId assigned to the row of the database.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addLocation(Location location) {
        jdbcTemplate.update(SQL_INSERT_LOCATION,
                location.getLocationName(),
                location.getLocationDescription(),
                location.getLocationAddress(),
                location.getLocationLatitude(),
                location.getLocationLongitude());

        int locationId
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);
        
        location.setLocationId(locationId);
    }

    @Override
    public void deleteLocation(int locationId) {
        jdbcTemplate.update(SQL_DELETE_LOCATION, locationId);
    }

    @Override
    public void updateLocation(Location location) {
        jdbcTemplate.update(SQL_UPDATE_LOCATION,
                location.getLocationName(),
                location.getLocationDescription(),
                location.getLocationAddress(),
                location.getLocationLatitude(),
                location.getLocationLongitude(),
                location.getLocationId());
    }

    @Override
    public Location getLocationById(int locationId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_LOCATION, 
                    new LocationMapper(),
                    locationId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
            // blank id, return null
        }
    }

    @Override
    public List<Location> getAllLocations() {
        return jdbcTemplate.query(SQL_SELECT_ALL_LOCATIONS, 
                new LocationMapper());
    }

    @Override
    public List<Location> getAllLocationsBySuperId(int superId) {
        return jdbcTemplate.query(SQL_SELECT_ALL_LOCATIONS_BY_SUPERID,
                new LocationMapper(), superId);
    }

}
