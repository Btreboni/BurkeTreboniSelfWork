/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.model.SuperPower;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import static com.sg.superhero.dao.PreparedStatements.*;
import com.sg.superhero.dao.SuperPowerMapperMethod.SuperPowerMapper;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 *
 * @author Burke Treboni
 */
public class SuperPowerDaoImpl implements SuperPowerDao {

    private JdbcTemplate jdbcTemplate;
    
    @Inject
    public SuperPowerDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addSuperPower(SuperPower superPower) {
        jdbcTemplate.update(SQL_INSERT_SUPERPOWER,
                superPower.getSuperPowerName());
        
        int superPowerId
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);
        
        superPower.setSuperPowerId(superPowerId);
    }

    @Override
    public void deleteSuperPower(int superPowerId) {
        jdbcTemplate.update(SQL_DELETE_SUPERPOWER, superPowerId);
    }

    @Override
    public void updateSuperPower(SuperPower superPower) {
        jdbcTemplate.update(SQL_UPDATE_SUPERPOWER,
                superPower.getSuperPowerName(),
                superPower.getSuperPowerId());
    }

    @Override
    public SuperPower getSuperPowerById(int superPowerId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_SUPERPOWER,
                    new SuperPowerMapper(),
                    superPowerId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<SuperPower> getAllSuperPowers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SUPERPOWERS,
                new SuperPowerMapper());
    }

    @Override
    public SuperPower getSuperPowerBySuperId(Integer superId) {
        return jdbcTemplate.queryForObject(SQL_SELECT_SP_BY_SUPERID,
                new SuperPowerMapper(), superId);
    }
    
    
    
}
