/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.model.Super;
import com.sg.superhero.model.SuperPower;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author admin
 */
public class SuperMapperMethod {
    
    protected static final class SuperMapper implements RowMapper<Super> {

        @Override
        public Super mapRow(ResultSet rs, int i) throws SQLException {
            Super sup = new Super();
            sup.setSuperId(rs.getInt("superId"));
            sup.setSuperName(rs.getString("superName"));
            sup.setSuperDescription(rs.getString("superDescription"));
            
            SuperPower power = new SuperPower();
            power.setSuperPowerId(rs.getInt(("superPowerId")));
            sup.setSuperPower(power);
            return sup;
        }
    }
}
