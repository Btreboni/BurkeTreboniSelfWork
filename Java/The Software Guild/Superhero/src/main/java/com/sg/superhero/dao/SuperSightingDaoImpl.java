/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.model.SuperSighting;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import static com.sg.superhero.dao.PreparedStatements.*;
import com.sg.superhero.dao.SuperSightingMapperMethod.SuperSightingMapper;
import com.sg.superhero.model.SuperHeroSighting;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 *
 * @author Burke Treboni
 */
public class SuperSightingDaoImpl implements SuperSightingDao {

    private JdbcTemplate jdbcTemplate;

    @Inject
    public SuperSightingDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addSuperSighting(SuperSighting superSighting) {
        jdbcTemplate.update(SQL_INSERT_SUPERSIGHTING,
                superSighting.getSuperHuman().getSuperId(),
                superSighting.getSighting().getSightingId());

        int superSightingId
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);

        superSighting.setSuperSightingId(superSightingId);
    }

    @Override
    public void deleteSuperSighting(int superSightingId) {
        jdbcTemplate.update(SQL_DELETE_SUPERSIGHTING, superSightingId);
    }

    @Override
    public void updateSuperSighting(SuperSighting superSighting) {
        jdbcTemplate.update(SQL_UPDATE_SUPERSIGHTING,
                superSighting.getSuperHuman().getSuperId(),
                superSighting.getSighting().getSightingId(),
                superSighting.getSuperSightingId());
    }

    @Override
    public SuperSighting getSuperSightingById(int superSightingId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_SUPERSIGHTING,
                    new SuperSightingMapper(),
                    superSightingId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<SuperSighting> getAllSuperSightings() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SUPERSIGHTING,
                new SuperSightingMapper());
    }

    @Override
    public SuperSighting getSuperSightingBySightingId(int sightingId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_SUPERSIGHTING,
                    new SuperSightingMapper(),
                    sightingId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
}
