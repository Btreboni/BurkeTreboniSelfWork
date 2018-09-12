/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.model.Organization;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Burke Treboni
 */
public class OrganizationMapperMethod {

    protected static final class OrganizationMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int i) throws SQLException {
            Organization org = new Organization();
            org.setOrganizationId(rs.getInt("organizationId"));
            org.setOrganizationName(rs.getString("organizationName"));
            org.setOrganizationDescription(rs.getString("organizationDescription"));
            org.setOrganizationAddress(rs.getString("organizationAddress"));
            org.setOrganizationPhone(rs.getString("organizationPhone"));
            org.setOrganizationEmail(rs.getString("organizationEmail"));
            return org;
            
        }

    }

}
