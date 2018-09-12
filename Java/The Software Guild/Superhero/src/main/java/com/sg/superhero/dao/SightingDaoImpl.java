/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.dao.LocationMapperMethod.LocationMapper;
import com.sg.superhero.dao.OrganizationMapperMethod.OrganizationMapper;
import com.sg.superhero.model.Sighting;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import static com.sg.superhero.dao.PreparedStatements.*;
import com.sg.superhero.dao.SightingMapperMethod.SightingMapper;
import com.sg.superhero.dao.SuperMapperMethod.SuperMapper;
import com.sg.superhero.model.Location;
import com.sg.superhero.model.Organization;
import com.sg.superhero.model.Super;
import com.sg.superhero.model.SuperHeroSighting;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 *
 * @author Burke Treboni
 */
public class SightingDaoImpl implements SightingDao {

    private JdbcTemplate jdbcTemplate;

    @Inject
    public SightingDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addSighting(Sighting sighting) {
        jdbcTemplate.update(SQL_INSERT_SIGHTING,
                Date.valueOf(sighting.getSightingDate()),
                sighting.getLocation().getLocationId());

        int sightingId
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);

        sighting.setSightingId(sightingId);
    }

    @Override
    public void deleteSighting(int sightingId) {
        jdbcTemplate.update(SQL_DELETE_SIGHTING, sightingId);
    }

    @Override
    public void updateSighting(Sighting sighting) {
        jdbcTemplate.update(SQL_UPDATE_SIGHTING,
                Date.valueOf(sighting.getSightingDate()),
                sighting.getLocation().getLocationId(),
                sighting.getSightingId());
    }

    @Override
    public List<Sighting> getAllSightings() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SIGHTINGS,
                new SightingMapper());
    }

    @Override
    public List<Sighting> getAllSightingsByLocation(int locationId) {
        return jdbcTemplate.query(SQL_RECORD_ALL_SIGHTINGS_BY_LOCATION,
                new SightingMapper(), locationId);
    }

    @Override
    public Location findLocationOfSighting(Sighting sighting) {
        List<Location> locations = jdbcTemplate.query(SQL_SELECT_LOCATION_BY_SIGHTING,
                new LocationMapper(), sighting.getSightingId());
        if (locations.size() == 0) {
            return null;
        }
        return locations.get(0);
    }

    @Override
    public List<Super> findSuperAtSighting(Sighting sighting) {
        return jdbcTemplate.query(SQL_SELECT_SUPER_BY_SIGHTING,
                new SuperMapper(), sighting.getSightingId());
    }

    @Override
    public List<Sighting> displayLocationSupersAndSightings(List<Sighting> sightingList) {
        for (Sighting sighting : sightingList) {
            sighting.setLocation(findLocationOfSighting(sighting));
            sighting.setSupers(findSuperAtSighting(sighting));
        }
        return sightingList;
    }

    @Override
    public List<SuperHeroSighting> getAllSightingsByDate() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SIGHTINGS_BY_DATE,
                new SuperHeroSightingMapper());
    }

    @Override
    public Sighting getSightingById(int sightingId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_SIGHTING,
                    new SightingMapper(),
                    sightingId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public Location getLocationBySightingID(int sightingId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_LOCATION_BY_SIGHTING, 
                    new LocationMapper(), sightingId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public Organization getOrganizationBySightingID(int sightingId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ORGANIZATION_BY_SIGHTING,
                    new OrganizationMapper(), sightingId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public Super getSuperBySightingID(int sightingId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_SUPER_BY_SIGHTING, 
                    new SuperMapper(), sightingId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

}
