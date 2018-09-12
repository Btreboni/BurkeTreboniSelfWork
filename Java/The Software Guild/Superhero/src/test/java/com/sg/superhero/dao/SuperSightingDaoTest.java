/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.model.Location;
import com.sg.superhero.model.Sighting;
import com.sg.superhero.model.Super;
import com.sg.superhero.model.SuperPower;
import com.sg.superhero.model.SuperSighting;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Burke Treboni
 */
public class SuperSightingDaoTest {

    SuperSightingDao superSightingDao;
    SightingDao sightingDao;
    SuperDao superDao;
    SuperPowerDao superPowerDao;
    LocationDao locationDao;

    public SuperSightingDaoTest() {
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
        superSightingDao = ctx.getBean("superSightingDao", SuperSightingDao.class);
        sightingDao = ctx.getBean("sightingDao", SightingDao.class);
        superPowerDao = ctx.getBean("superPowerDao", SuperPowerDao.class);
        locationDao = ctx.getBean("locationDao", LocationDao.class);

        List<SuperSighting> supersight = superSightingDao.getAllSuperSightings();
        if (supersight != null) {
            for (SuperSighting currentSuperSighting : supersight) {
                superSightingDao
                        .deleteSuperSighting(currentSuperSighting.getSuperSightingId());
            }
        }
    }

    @After
    public void tearDown() {
        List<SuperSighting> supersight = superSightingDao.getAllSuperSightings();
        if (supersight != null) {
            for (SuperSighting currentSuperSighting : supersight) {
                superSightingDao
                        .deleteSuperSighting(currentSuperSighting.getSuperSightingId());
            }
        }
    }

    @Test
    public void addGetSuperSighting() {

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
        //Think about populating tables; you need to build up parent tables
        //to allow the child tables to be populated. 
        sSight.setSuperHuman(su);
        sSight.setSighting(si);

        superSightingDao.addSuperSighting(sSight);

        SuperSighting fromDao = superSightingDao
                .getSuperSightingById(sSight.getSuperSightingId());
        assertEquals(fromDao, sSight);
    }

    @Test
    public void deleteSuperSighting() {
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
        //Think about populating tables; you need to build up parent tables
        //to allow the child tables to be populated. 
        sSight.setSuperHuman(su);
        sSight.setSighting(si);

        superSightingDao.addSuperSighting(sSight);

        SuperSighting fromDao = superSightingDao
                .getSuperSightingById(sSight.getSuperSightingId());
        assertEquals(fromDao, sSight);

        superSightingDao.deleteSuperSighting(sSight.getSuperSightingId());
        assertNull(superSightingDao.getSuperSightingById(sSight.getSuperSightingId()));
    }

    @Test
    public void testAddUpdateSuperSighting() {
        SuperPower spow = new SuperPower();
        spow.setSuperPowerName("Flight");

        superPowerDao.addSuperPower(spow);

        Super su = new Super();
        su.setSuperName("Superman");
        su.setSuperDescription("Man of Steel");
        su.setSuperPower(spow);

        superDao.addSuper(su);
        String superman = "Superman";
        Super fromSPDao = superDao.getSuperById(su.getSuperId());
        assertEquals(fromSPDao.getSuperName(), superman);

        String batman = "Batman";
        fromSPDao.setSuperName(batman);
        fromSPDao.setSuperDescription("Man of Steel");
        fromSPDao.setSuperPower(spow);
        superDao.updateSuper(fromSPDao);

        Super fromSPUpdateDao = superDao.getSuperById(su.getSuperId());
        assertEquals(fromSPUpdateDao.getSuperName(), batman);

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
        //Think about populating tables; you need to build up parent tables
        //to allow the child tables to be populated. 
        sSight.setSuperHuman(su);
        sSight.setSighting(si);

        superSightingDao.addSuperSighting(sSight);

        SuperSighting fromDao = superSightingDao
                .getSuperSightingById(sSight.getSuperSightingId());
        assertEquals(fromDao, sSight);
    }

    @Test
    public void getAllSuperSightings() {
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
        //Think about populating tables; you need to build up parent tables
        //to allow the child tables to be populated. 
        sSight.setSuperHuman(su);
        sSight.setSighting(si);

        superSightingDao.addSuperSighting(sSight);

        SuperSighting fromDao = superSightingDao
                .getSuperSightingById(sSight.getSuperSightingId());
        assertEquals(fromDao, sSight);
        
        List<SuperSighting> superSightinglist = superSightingDao.getAllSuperSightings();
        assertEquals(superSightinglist.size(), 1);
    }
}
