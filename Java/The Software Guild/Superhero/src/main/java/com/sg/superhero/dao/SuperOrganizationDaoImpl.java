/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.model.SuperOrganization;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import static com.sg.superhero.dao.PreparedStatements.*;
import com.sg.superhero.dao.SuperOrganizationMapperMethod.SuperOrganizationMapper;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 *
 * @author Burke Treboni
 */
public class SuperOrganizationDaoImpl implements SuperOrganizationDao {

    JdbcTemplate jdbcTemplate;
    
    @Inject
    public SuperOrganizationDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addSuperOrganization(SuperOrganization superOrganization) {
        jdbcTemplate.update(SQL_INSERT_SUPERORGANIZATION,
                superOrganization.getSuperHuman().getSuperId(),
                superOrganization.getOrganization().getOrganizationId());
        
        int superOrganizationId
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);
        
        superOrganization.setSuperOrganizationId(superOrganizationId);
    }

    @Override
    public void deleteSuperOrganization(int superId) {
        jdbcTemplate.update(SQL_DELETE_SUPERORGANIZATION, superId);
    }

    @Override
    public void updateSuperOrganization(SuperOrganization superOrganization) {
        jdbcTemplate.update(SQL_UPDATE_SUPERORGANIZATION,
                superOrganization.getSuperHuman().getSuperId(),
                superOrganization.getOrganization().getOrganizationId(),
                superOrganization.getSuperOrganizationId());
    }

    @Override
    public SuperOrganization getSuperOrganizationById(int superOrganizationId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_SUPERORGANIZATION,
                    new SuperOrganizationMapper(),
                    superOrganizationId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<SuperOrganization> getAllSuperOrganizations() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SUPERORGANIZATION,
                new SuperOrganizationMapper());
    }   

    @Override
    public SuperOrganization getSuperOrganizationBySuperId(int superId) {
                try {
            return jdbcTemplate.queryForObject(SQL_SELECT_SUPERORGANIZATION,
                    new SuperOrganizationMapper(),
                    superId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
}
