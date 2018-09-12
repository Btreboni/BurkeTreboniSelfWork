/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.model.Location;
import com.sg.superhero.model.Sighting;
import com.sg.superhero.model.SuperHeroSighting;
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
public class SightingDaoTest {

    SightingDao sightingDao;
    SuperSightingDao superSightingDao;
    LocationDao locationDao;

    public SightingDaoTest() {
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

        sightingDao = ctx.getBean("sightingDao", SightingDao.class);
        locationDao = ctx.getBean("locationDao", LocationDao.class);
        superSightingDao = ctx.getBean("superSightingDao", SuperSightingDao.class);

        List<SuperSighting> superSighting = superSightingDao.getAllSuperSightings();
        if (superSighting != null) {
            for (SuperSighting currentSuperSighting : superSighting) {
                superSightingDao.deleteSuperSighting(currentSuperSighting.getSuperSightingId());
            }
        }

        List<Sighting> sight = sightingDao.getAllSightings();
        if (sight != null) {
            for (Sighting currentSighting : sight) {
                sightingDao.deleteSighting(currentSighting.getSightingId());
            }
        }
    }

    @After
    public void tearDown() {
        List<SuperSighting> superSighting = superSightingDao.getAllSuperSightings();
        if (superSighting != null) {
            for (SuperSighting currentSuperSighting : superSighting) {
                superSightingDao.deleteSuperSighting(currentSuperSighting.getSuperSightingId());
            }
        }

        List<Sighting> sight = sightingDao.getAllSightings();
        if (sight != null) {
            for (Sighting currentSighting : sight) {
                sightingDao.deleteSighting(currentSighting.getSightingId());
            }
        }
    }

    @Test
    public void addGetSighting() {
        LocalDate ldv = LocalDate.now();

        Location loc = new Location();
        loc.setLocationName("The Software Guild");
        loc.setLocationDescription("Multi-Building Campus");
        loc.setLocationAddress("526 South Main Street Suite 609, Akron, OH 44311");
        loc.setLocationLatitude(41.071827);
        loc.setLocationLongitude(-81.527073);

        locationDao.addLocation(loc);

        Location fromLDao = locationDao.getLocationById(loc.getLocationId());
        assertEquals(fromLDao, loc);

        Sighting sighting = new Sighting();
        sighting.setSightingDate(ldv);
        sighting.setLocation(loc);

        sightingDao.addSighting(sighting);

        Sighting fromSDao = sightingDao.getSightingById(sighting.getSightingId());
        assertEquals(fromSDao, sighting);

    }

    @Test
    public void deleteSighting() {
        LocalDate ldv = LocalDate.now();

        Location loc = new Location();
        loc.setLocationName("The Software Guild");
        loc.setLocationDescription("Multi-Building Campus");
        loc.setLocationAddress("526 South Main Street Suite 609, Akron, OH 44311");
        loc.setLocationLatitude(41.071827);
        loc.setLocationLongitude(-81.527073);

        locationDao.addLocation(loc);

        Location fromLDao = locationDao.getLocationById(loc.getLocationId());
        assertEquals(fromLDao, loc);

        Sighting sighting = new Sighting();
        sighting.setSightingDate(ldv);
        sighting.setLocation(loc);

        sightingDao.addSighting(sighting);

        Sighting fromSDao = sightingDao.getSightingById(sighting.getSightingId());
        assertEquals(fromSDao, sighting);

        sightingDao.deleteSighting(sighting.getSightingId());
        assertNull(sightingDao.getSightingById(sighting.getSightingId()));
    }

    @Test
    public void testAddUpdateSighting() {

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
        Integer locationId = locationDao.getAllLocations().get(0).getLocationId();
        si.setLocation(loc);

        sightingDao.addSighting(si);

        Sighting fromDao = sightingDao.getSightingById(si.getSightingId());
        assertEquals(fromDao, si);
    }

    @Test
    public void testAddGetAllSightings() {
        LocalDate ldv = LocalDate.now();

        Location loc = new Location();
        loc.setLocationName("The Software Guild");
        loc.setLocationDescription("Multi-Building Campus");
        loc.setLocationAddress("526 South Main Street Suite 609, Akron, OH 44311");
        loc.setLocationLatitude(41.071827);
        loc.setLocationLongitude(-81.527073);

        locationDao.addLocation(loc);

        Location fromLDao = locationDao.getLocationById(loc.getLocationId());
        assertEquals(fromLDao, loc);

        Sighting sighting = new Sighting();
        sighting.setSightingDate(ldv);
        sighting.setLocation(loc);

        sightingDao.addSighting(sighting);

        Sighting fromSDao = sightingDao.getSightingById(sighting.getSightingId());
        assertEquals(fromSDao, sighting);

        LocalDate ldv2 = LocalDate.now();

        Location loc2 = new Location();
        loc2.setLocationName("Metropolis");
        loc2.setLocationDescription("It's big");
        loc2.setLocationAddress("123 Main St.");
        loc2.setLocationLatitude(44.071827);
        loc2.setLocationLongitude(-82.527073);

        locationDao.addLocation(loc2);

        Location fromLDao2 = locationDao.getLocationById(loc2.getLocationId());
        assertEquals(fromLDao2, loc2);

        Sighting sighting2 = new Sighting();
        sighting2.setSightingDate(ldv2);
        sighting2.setLocation(loc2);

        sightingDao.addSighting(sighting2);

        Sighting fromSDao2 = sightingDao.getSightingById(sighting2.getSightingId());
        assertEquals(fromSDao2, sighting2);

        List<Sighting> allSightings = sightingDao.getAllSightings();
        assertEquals(allSightings.size(), 2);
    }

    @Test
    public void getAllSightingsByDate() {

        Location loc = new Location();
        loc.setLocationName("The Software Guild");
        loc.setLocationDescription("Multi-Building Campus");
        loc.setLocationAddress("526 South Main Street Suite 609, Akron, OH 44311");
        loc.setLocationLatitude(41.071827);
        loc.setLocationLongitude(-81.527073);

        locationDao.addLocation(loc);

        Sighting si = new Sighting();
        si.setSightingDate(LocalDate.now());
        si.setLocation(loc);

        sightingDao.addSighting(si);

        List<SuperHeroSighting> sightingList = sightingDao.getAllSightingsByDate();
        assertEquals(sightingList.size(), 0);
    }

    @Test
    public void getAllSightingsByLocation() {

        Location loc = new Location();
        loc.setLocationName("Metropolis");
        loc.setLocationDescription("Corner Building");
        loc.setLocationAddress("123 Main Street");
        loc.setLocationLatitude(14.123);
        loc.setLocationLongitude(-23.43434);

        locationDao.addLocation(loc);

        Sighting si = new Sighting();
        si.setSightingDate(LocalDate.now());
        si.setLocation(loc);

        sightingDao.addSighting(si);

        List<Sighting> sightingList = sightingDao.getAllSightingsByLocation(loc.getLocationId());
        assertEquals(sightingList.size(), 0);
    }

}
