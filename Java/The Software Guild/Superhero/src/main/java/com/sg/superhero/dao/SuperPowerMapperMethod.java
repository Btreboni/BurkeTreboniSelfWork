/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.model.SuperPower;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Burke Treboni
 */
public class SuperPowerMapperMethod {
        protected static final class SuperPowerMapper 
            implements RowMapper<SuperPower> {

        @Override
        public SuperPower mapRow(ResultSet rs, int i) throws SQLException {
            SuperPower power = new SuperPower();
            power.setSuperPowerId(rs.getInt(("superPowerId")));
            power.setSuperPowerName(rs.getString("superPowerName"));
            return power;
        }
    }
}
