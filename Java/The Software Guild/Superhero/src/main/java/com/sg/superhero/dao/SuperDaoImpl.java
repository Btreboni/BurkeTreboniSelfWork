/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.model.Super;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import static com.sg.superhero.dao.PreparedStatements.*;
import com.sg.superhero.dao.SuperMapperMethod.SuperMapper;
import com.sg.superhero.model.SuperHeroOrgList;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Burke Treboni
 */
public class SuperDaoImpl implements SuperDao {

    private JdbcTemplate jdbcTemplate;

    @Inject
    public SuperDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addSuper(Super superP) {
        jdbcTemplate.update(SQL_INSERT_SUPER,
                superP.getSuperName(),
                superP.getSuperDescription(),
                superP.getSuperPower().getSuperPowerId());

        int superId
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);

        superP.setSuperId(superId);
    }

    @Override
    public void deleteSuper(int superId) {
        jdbcTemplate.update(SQL_DELETE_SUPER, superId);
    }

    @Override
    public void updateSuper(Super superP) {
        jdbcTemplate.update(SQL_UPDATE_SUPER,
                superP.getSuperName(),
                superP.getSuperDescription(),
                superP.getSuperPower().getSuperPowerId(),
                superP.getSuperId());
    }

    @Override
    public Super getSuperById(int superId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_SUPER,
                    new SuperMapper(),
                    superId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Super> getAllSupers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SUPERS,
                new SuperMapper());
    }

    @Override
    public List<Super> getAllSuperByLocationId(int locationId) {
        return jdbcTemplate.query(SQL_SELECT_ALL_SUPER_BY_LOCATIONID,
                new SuperMapper(),
                locationId);
    }

    @Override
    public List<Super> getAllSuperByOrganization(int organizationId) {
        return jdbcTemplate.query(SQL_SELECT_ALL_SUPER_BY_ORGANIZATION,
                new SuperMapper(),
                organizationId);
    }

    @Override
    public List<SuperHeroOrgList> loadSuperHeros() {
        return jdbcTemplate.query(SQL_SELECT_SUPER_HEROS,
                new SuperHeroOrgListMapper());
    }


}
