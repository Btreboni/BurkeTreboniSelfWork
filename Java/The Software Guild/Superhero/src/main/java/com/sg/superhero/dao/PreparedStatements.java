/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

/**
 *
 * @author Burke Treboni
 */
public class PreparedStatements {

    // All of these statements are basic CRUD statements for the location table 
    // Location Statements
    protected static final String SQL_INSERT_LOCATION
            = "insert into location (locationName, "
            + "locationDescription, locationAddress, locationLatitude, "
            + "locationLongitude) values (?, ?, ?, ?, ?)";

    protected static final String SQL_DELETE_LOCATION
            = "delete from location where locationId = ?";

    protected static final String SQL_UPDATE_LOCATION
            = "update location set locationName = ?, "
            + "locationDescription = ?, locationAddress = ?, "
            + "locationLatitude = ?, locationLongitude = ?"
            + "where locationId = ?";

    protected static final String SQL_SELECT_LOCATION
            = "select * from location where locationId = ?";

    protected static final String SQL_SELECT_ALL_LOCATIONS
            = "select * from location";

    protected static final String SQL_SELECT_ALL_LOCATIONS_BY_SUPERID
            = "select l.* "
            + "from location l "
            + "join sighting si on l.locationId = si.locationId "
            + "join super_sighting ss on si.sightingid = ss.sightingId "
            + "join `super` s on ss.superId = s.superId "
            + "where s.superId = ?";

    protected static final String SQL_SELECT_ALL_SUPER_BY_LOCATIONID
            = "select s.*, l.locationId, l.locationName "
            + "from `super` s "
            + "join super_sighting ss on s.superId = ss.superId "
            + "join sighting si on ss.sightingId = si.sightingId "
            + "join location l on si.locationId = si.locationId "
            + "where l.locationId = ?";

    // Organization Statements
    protected static final String SQL_INSERT_ORGANIZATION
            = "insert into organization "
            + "(organizationName, organizationDescription, organizationAddress, "
            + "organizationPhone, organizationEmail) "
            + "values (?, ?, ?, ?, ?)";

    protected static final String SQL_DELETE_ORGANIZATION
            = "delete from organization where organizationId = ?";

    protected static final String SQL_UPDATE_ORGANIZATION
            = "update organization set organizationName = ?, "
            + "organizationDescription = ?, organizationAddress = ?, "
            + "organizationPhone = ?, organizationEmail = ?"
            + "where organizationId = ?";

    protected static final String SQL_SELECT_ORGANIZATION
            = "select * from organization where organizationId = ?";

    protected static final String SQL_SELECT_ALL_ORGANIZATIONS
            = "select * from organization";

    //Sighting Statements
    protected static final String SQL_INSERT_SIGHTING
            = "insert into sighting "
            + "(sightingDate, locationId) "
            + "values (?, ?)";

    protected static final String SQL_DELETE_SIGHTING
            = "delete from sighting where sightingId = ?";

    protected static final String SQL_UPDATE_SIGHTING
            = "update sighting set sightingDate = ?, "
            + "locationId = ? "
            + "where sightingId = ?";

    protected static final String SQL_SELECT_SIGHTING
            = "select * from sighting where sightingId = ?";

    protected static final String SQL_SELECT_ALL_SIGHTINGS
            = "select * from sighting";

    //Need to implement those below
    protected static final String SQL_RECORD_ALL_SIGHTINGS_BY_LOCATION
            = "select si.* from sighting si "
            + "join location l on si.locationId = l.locationId "
            + "where l.locationId = ?";

    protected static final String SQL_SELECT_ALL_SIGHTINGS_BY_DATE
            = "select s.sightingId, s.sightingDate, sup.superName, l.locationName, o.organizationName "
            + "from sighting s "
            + "inner join super_sighting ss on s.sightingID = ss.sightingId "
            + "inner join super sup on ss.superId = sup.superId "
            + "inner join super_organization so on sup.superId = so.superId "
            + "inner join organization o on so.organizationId = o.organizationId "
            + "inner join location l on s.locationId = l.locationId "
            + "order by s.sightingDate desc";

    protected static final String SQL_SELECT_LOCATION_BY_SIGHTING
            = "select l.* from location l "
            + "inner join sighting see on see.locationId = l.locationId "
            + "inner join super_sighting ss on see.sightingId = ss.sightingId "
            + "where ss.sightingId = ?";
    
    protected static final String SQL_SELECT_SUPER_BY_SIGHTING
            = "select s.* from `super` s "
            + "join super_sighting ss on ss.superId = s.superId "
            + "join sighting see on see.sightingId = ss.sightingId "
            + "where ss.sightingId = ?";
    
    protected static final String SQL_SELECT_ORGANIZATION_BY_SIGHTING
            = "select o.* from organization o "
            + "inner join super_organization so on o.organizationId = so.organizationId "
            + "inner join `super` s on so.superId = s.superId "
            + "inner join super_sighting ss on s.superId = ss.superId "
            + "inner join sighting see on ss.sightingId = see.sightingId "
            + "where ss.sightingId = ?";
            
    //Super Statements
    protected static final String SQL_INSERT_SUPER
            = "insert into `super` "
            + "(superName, superDescription, superPowerId) "
            + "values (?, ?, ?)";

    protected static final String SQL_DELETE_SUPER
            = "delete from `super` where superId = ?";

    protected static final String SQL_UPDATE_SUPER
            = "update super set superName = ?, superDescription = ?, "
            + "superPowerId = ? "
            + "where superId = ?";

    protected static final String SQL_SELECT_SUPER
            = "select * from `super` where superId = ?";

    protected static final String SQL_SELECT_ALL_SUPERS
            = "select * from `super`";

    protected static final String SQL_SELECT_SUPER_HEROS
            = "select s.superId, s.superName, s.superDescription, sp.superPowerId,sp.superPowerName, o.organizationName "
            + "from `super` s "
            + "inner join super_power sp on s.superPowerId = sp.superPowerId "
            + "inner join super_organization so on s.superId = so.superId "
            + "inner join organization o on so.organizationId = o.organizationId "
            + "order by s.superName desc";
            

    //SuperOrganization Statements
    protected static final String SQL_INSERT_SUPERORGANIZATION
            = "insert into super_organization "
            + "(superId, organizationId) "
            + "values (?, ?)";

    protected static final String SQL_DELETE_SUPERORGANIZATION
            = "delete from super_organization where superOrganizationId = ?";

    protected static final String SQL_UPDATE_SUPERORGANIZATION
            = "update super_organization set superId = ?, "
            + "organizationId = ? "
            + "where superOrganizationId = ?";

    protected static final String SQL_SELECT_SUPERORGANIZATION
            = "select * from super_organization "
            + "where superId = ?";

    protected static final String SQL_SELECT_ALL_SUPERORGANIZATION
            = "select * from super_organization";

    protected static final String SQL_SELECT_ALL_SUPER_BY_ORGANIZATION
            = "select o.*, s.* "
            + "from `super` s "
            + "join super_organization so on s.superId = so.superId "
            + "join organization o on so.organizationId = o.organizationId "
            + "where o.organizationId = ?";

    protected static final String SQL_SELECT_ALL_ORGANIZATION_BY_SUPER
            = "select s.superId, s.superName, o.* "
            + "from organization o "
            + "join super_organization so on o.organizationId = so.organizationId "
            + "join `super`s on so.superId = s.superId "
            + "where s.superId = ?";

    //SuperPower Statements
    protected static final String SQL_INSERT_SUPERPOWER
            = "insert into super_power "
            + "(superPowerName) values (?)";

    protected static final String SQL_DELETE_SUPERPOWER
            = "delete from super_power where superPowerId = ?";

    protected static final String SQL_UPDATE_SUPERPOWER
            = "update super_power set superPowerName = ?"
            + "where superPowerId = ?";

    protected static final String SQL_SELECT_SUPERPOWER
            = "select * from super_power where superPowerId = ?";

    protected static final String SQL_SELECT_ALL_SUPERPOWERS
            = "select * from super_power";

    protected static final String SQL_SELECT_SP_BY_SUPERID
            = "select * from super_power where superPowerId = ?";

    //SuperSighting Statements
    protected static final String SQL_INSERT_SUPERSIGHTING
            = "insert into super_sighting "
            + "(superId, sightingId) "
            + " values (?, ?)";

    protected static final String SQL_DELETE_SUPERSIGHTING
            = "delete from super_sighting where superSightingId = ?";

    protected static final String SQL_UPDATE_SUPERSIGHTING
            = "update super_sighting set superId = ?, "
            + "sightingId = ? "
            + "where superSightingId = ?";

    protected static final String SQL_SELECT_SUPERSIGHTING
            = "select * from super_sighting where sightingId = ?";

    protected static final String SQL_SELECT_ALL_SUPERSIGHTING
            = "select * from super_sighting";

}
