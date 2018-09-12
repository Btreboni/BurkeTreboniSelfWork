/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.model.Location;
import com.sg.superhero.model.Organization;
import com.sg.superhero.model.Sighting;
import com.sg.superhero.model.Super;
import com.sg.superhero.model.SuperOrganization;
import com.sg.superhero.model.SuperPower;
import com.sg.superhero.model.SuperSighting;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Burke Treboni
 */
public class SuperDaoTest {

    SuperDao superDao;
    SuperPowerDao superPowerDao;
    SuperOrganizationDao superOrganizationDao;
    SuperSightingDao superSightingDao;
    SightingDao sightingDao;
    OrganizationDao organizationDao;
    LocationDao locationDao;

    public SuperDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        superDao = ctx.getBean("superDao", SuperDao.class);
        superPowerDao = ctx.getBean("superPowerDao", SuperPowerDao.class);
        superOrganizationDao
                = ctx.getBean("superOrganizationDao", SuperOrganizationDao.class);
        superSightingDao = ctx.getBean("superSightingDao", SuperSightingDao.class);
        sightingDao = ctx.getBean("sightingDao", SightingDao.class);
        organizationDao = ctx.getBean("organizationDao", OrganizationDao.class);
        locationDao = ctx.getBean("locationDao", LocationDao.class);

        List<SuperSighting> sSighting = superSightingDao.getAllSuperSightings();
        if (sSighting != null) {
            for (SuperSighting currentSuperSighting : sSighting) {
                superSightingDao
                        .deleteSuperSighting(
                                currentSuperSighting.getSuperSightingId());
            }
        }

        List<SuperOrganization> superOrgs
                = superOrganizationDao.getAllSuperOrganizations();
        if (superOrgs != null) {
            for (SuperOrganization currentSuperOrg : superOrgs) {
                superOrganizationDao
                        .deleteSuperOrganization(
                                currentSuperOrg.getSuperOrganizationId());
            }
        }

        List<Super> supers = superDao.getAllSupers();
        if (supers != null) {
            for (Super currentSuper : supers) {
                superDao.deleteSuper(currentSuper.getSuperId());
            }
        }
    }

    @After
    public void tearDown() {
        List<SuperSighting> sSighting = superSightingDao.getAllSuperSightings();
        if (sSighting != null) {
            for (SuperSighting currentSuperSighting : sSighting) {
                superSightingDao
                        .deleteSuperSighting(
                                currentSuperSighting.getSuperSightingId());
            }
        }

        List<SuperOrganization> superOrgs
                = superOrganizationDao.getAllSuperOrganizations();
        if (superOrgs != null) {
            for (SuperOrganization currentSuperOrg : superOrgs) {
                superOrganizationDao
                        .deleteSuperOrganization(
                                currentSuperOrg.getSuperOrganizationId());
            }
        }

        List<Super> supers = superDao.getAllSupers();
        if (supers != null) {
            for (Super currentSuper : supers) {
                superDao.deleteSuper(currentSuper.getSuperId());
            }
        }
    }

    @Test
    public void addGetSuper() {

        SuperPower spow = new SuperPower();
        spow.setSuperPowerName("Flight");

        superPowerDao.addSuperPower(spow);

        SuperPower fromSPDao = superPowerDao.getSuperPowerById(spow.getSuperPowerId());
        assertEquals(fromSPDao, spow);

        Super su = new Super();
        su.setSuperName("Superman");
        su.setSuperDescription("Man of Steel");
        su.setSuperPower(spow);

        superDao.addSuper(su);

        Super fromDao = superDao.getSuperById(su.getSuperId());
        assertEquals(fromDao, su);
    }

    @Test
    public void deleteSuper() {
        SuperPower spow = new SuperPower();
        spow.setSuperPowerName("Flight");

        superPowerDao.addSuperPower(spow);

        SuperPower fromSPDao = superPowerDao.getSuperPowerById(spow.getSuperPowerId());
        assertEquals(fromSPDao, spow);

        Super su = new Super();
        su.setSuperName("Superman");
        su.setSuperDescription("Man of Steel");
        su.setSuperPower(spow);

        superDao.addSuper(su);

        Super fromDao = superDao.getSuperById(su.getSuperId());
        assertEquals(fromDao, su);

        superDao.deleteSuper(su.getSuperId());
        assertNull(superDao.getSuperById(su.getSuperId()));
    }

    @Test
    public void testAddUpdateSuper() {
        SuperPower spow = new SuperPower();
        spow.setSuperPowerName("Flight");

        superPowerDao.addSuperPower(spow);

        SuperPower fromSPDao = superPowerDao.getSuperPowerById(spow.getSuperPowerId());
        assertEquals(fromSPDao, spow);

        Super su = new Super();
        su.setSuperName("Superman");
        su.setSuperDescription("Man of Steel");
        su.setSuperPower(spow);

        superDao.addSuper(su);

        String name = "Superman";
        Super fromDao = superDao.getSuperById(su.getSuperId());
        assertEquals(fromDao.getSuperName(), name);

        String newName = "Batman";
        String bat = "Dark Night";

        fromDao.setSuperName(newName);
        fromDao.setSuperDescription(bat);
        fromDao.setSuperPower(spow);

        superDao.updateSuper(fromDao);

        Super fromUpdateDao = superDao.getSuperById(su.getSuperId());
        assertEquals(fromUpdateDao.getSuperName(), newName);
    }

    @Test
    public void getAllSupers() {
        //Make 1 object
        SuperPower spow = new SuperPower();
        spow.setSuperPowerName("Flight");

        superPowerDao.addSuperPower(spow);

        SuperPower fromSPDao = superPowerDao.getSuperPowerById(spow.getSuperPowerId());
        assertEquals(fromSPDao, spow);

        Super su = new Super();
        su.setSuperName("Superman");
        su.setSuperDescription("Man of Steel");
        su.setSuperPower(spow);

        superDao.addSuper(su);

        Super fromDao = superDao.getSuperById(su.getSuperId());
        assertEquals(fromDao, su);

        // Make second object
        SuperPower spow2 = new SuperPower();
        spow2.setSuperPowerName("Lazer Eyes");

        superPowerDao.addSuperPower(spow2);

        SuperPower fromSPDao2 = superPowerDao.getSuperPowerById(spow2.getSuperPowerId());
        assertEquals(fromSPDao2, spow2);

        Super su2 = new Super();
        su2.setSuperName("Not Superman");
        su2.setSuperDescription("Not The Man of Steel");
        su2.setSuperPower(spow2);

        superDao.addSuper(su2);

        Super fromDao2 = superDao.getSuperById(su2.getSuperId());
        assertEquals(fromDao2, su2);
    }

    @Test
    public void testGetAllSuperByLocationId() {
        //First Object
        SuperPower spow = new SuperPower();
        spow.setSuperPowerName("Flight");

        superPowerDao.addSuperPower(spow);

        Super su = new Super();
        su.setSuperName("Superman");
        su.setSuperDescription("Man of Steel");
        su.setSuperPower(spow);

        superDao.addSuper(su);

        Location loc = new Location();
        loc.setLocationName("The Software Guild");
        loc.setLocationDescription("Multi-Building Campus");
        loc.setLocationAddress("526 South Main Street Suite 609, Akron, OH 44311");
        loc.setLocationLatitude(41.071827);
        loc.setLocationLongitude(-81.527073);

        locationDao.addLocation(loc);

        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String testDate = sdf.format(dt);

        Sighting si = new Sighting();
        si.setSightingDate(LocalDate.now());
        si.setLocation(loc);

        sightingDao.addSighting(si);

        SuperSighting sSight = new SuperSighting();
        sSight.setSuperHuman(su);
        sSight.setSighting(si);

        superSightingDao.addSuperSighting(sSight);

        SuperSighting fromDao = superSightingDao
                .getSuperSightingById(sSight.getSuperSightingId());
        assertEquals(fromDao, sSight);

        //Second Object
        SuperPower spow2 = new SuperPower();
        spow2.setSuperPowerName("Runs Fast");

        superPowerDao.addSuperPower(spow2);

        Super su2 = new Super();
        su2.setSuperName("Batman");
        su2.setSuperDescription("He a Bat!");
        su2.setSuperPower(spow2);

        superDao.addSuper(su2);

        Location loc2 = new Location();
        loc2.setLocationName("Chipotle");
        loc2.setLocationDescription("Corner Building");
        loc2.setLocationAddress("223 Main Street Akron, OH 44311");
        loc2.setLocationLatitude(23.4234234);
        loc2.setLocationLongitude(-12.123123123);

        locationDao.addLocation(loc2);

        Date dt2 = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String testDate2 = sdf2.format(dt2);

        Sighting si2 = new Sighting();
        si2.setSightingDate(LocalDate.now());
        si2.setLocation(loc2);

        sightingDao.addSighting(si2);

        SuperSighting sSight2 = new SuperSighting();
        sSight2.setSuperHuman(su2);
        sSight2.setSighting(si2);

        superSightingDao.addSuperSighting(sSight2);

        SuperSighting fromDao2 = superSightingDao
                .getSuperSightingById(sSight2.getSuperSightingId());
        assertEquals(fromDao2, sSight2);

        List<Super> superList = superDao.getAllSuperByLocationId(loc.getLocationId());
        assertEquals(superList.size(), 2);
    }

    @Test
    public void getAllSuperByOrganizationId() {
        //First Object
        SuperPower spow = new SuperPower();
        spow.setSuperPowerName("Flight");

        superPowerDao.addSuperPower(spow);

        Super su = new Super();
        su.setSuperName("Superman");
        su.setSuperDescription("Man of Steel");
        su.setSuperPower(spow);

        superDao.addSuper(su);

        Location loc = new Location();
        loc.setLocationName("The Software Guild");
        loc.setLocationDescription("Multi-Building Campus");
        loc.setLocationAddress("526 South Main Street Suite 609, Akron, OH 44311");
        loc.setLocationLatitude(41.071827);
        loc.setLocationLongitude(-81.527073);

        locationDao.addLocation(loc);

        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String testDate = sdf.format(dt);

        Sighting si = new Sighting();
        si.setSightingDate(LocalDate.now());
        si.setLocation(loc);

        sightingDao.addSighting(si);

        SuperSighting sSight = new SuperSighting();
        sSight.setSuperHuman(su);
        sSight.setSighting(si);

        superSightingDao.addSuperSighting(sSight);

        Organization org = new Organization();
        org.setOrganizationName("The Software Guild");
        org.setOrganizationDescription("Multi Building");
        org.setOrganizationAddress("123 Wrong Way BLVD");
        org.setOrganizationPhone("6149999999");
        org.setOrganizationEmail("PToner@SG.com");

        organizationDao.addOrganization(org);

        SuperOrganization sOrg = new SuperOrganization();
        sOrg.setOrganization(org);
        sOrg.setSuperHuman(su);

        superOrganizationDao.addSuperOrganization(sOrg);

        List<Super> superList = superDao.getAllSuperByOrganization(org.getOrganizationId());
        assertEquals(superList.size(), 1);
    }
}
