/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.model.Organization;
import com.sg.superhero.model.Super;
import com.sg.superhero.model.SuperOrganization;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author admin
 */
public class SuperOrganizationMapperMethod {
    
    protected static final class SuperOrganizationMapper 
            implements RowMapper<SuperOrganization> {

        @Override
        public SuperOrganization mapRow(ResultSet rs, int i) throws SQLException {
            SuperOrganization so = new SuperOrganization();
            so.setSuperOrganizationId(rs.getInt("superOrganizationId"));
            
            Organization org = new Organization();
            org.setOrganizationId(rs.getInt("organizationId"));
            so.setOrganization(org);
            
            Super s = new Super();
            s.setSuperId(rs.getInt("superId"));
            so.setSuperHuman(s);
            
            return so;
        }
    }
}
