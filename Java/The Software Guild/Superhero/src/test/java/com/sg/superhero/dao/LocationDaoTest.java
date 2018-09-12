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
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Burke Treboni
 */
public class LocationDaoTest {

    LocationDao locationDao;
    SightingDao sightingDao;
    SuperSightingDao superSightingDao;
    SuperDao superDao;
    SuperPowerDao superPowerDao;

    private int myId;

    public LocationDaoTest() {
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
        superSightingDao = ctx.getBean("superSightingDao", SuperSightingDao.class);
        sightingDao = ctx.getBean("sightingDao", SightingDao.class);
        locationDao = ctx.getBean("locationDao", LocationDao.class);

        List<SuperSighting> superSighting = superSightingDao.getAllSuperSightings();
        if (superSighting != null) {
            superSighting.forEach((currentSuperSighting) -> {
                superSightingDao.deleteSuperSighting(currentSuperSighting.getSuperSightingId());
            });
        }

        List<Sighting> sighting = sightingDao.getAllSightings();
        if (sighting != null) {
            sighting.forEach((currentSighting) -> {
                sightingDao.deleteSighting(currentSighting.getSightingId());
            });
        }

        List<Location> locs = locationDao.getAllLocations();
        if (locs != null) {
            locs.forEach((currentLocation) -> {
                locationDao.deleteLocation(currentLocation.getLocationId());
            });
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

        List<Sighting> sighting = sightingDao.getAllSightings();
        if (sighting != null) {
            for (Sighting currentSighting : sighting) {
                sightingDao.deleteSighting(currentSighting.getSightingId());
            }
        }

        List<Location> locs = locationDao.getAllLocations();
        if (locs != null) {
            for (Location currentLocation : locs) {
                locationDao.deleteLocation(currentLocation.getLocationId());
            }
        }
    }

    @Test
    public void testAddLocation() {

        Location loc = new Location();
        loc.setLocationName("The Software Guild");
        loc.setLocationDescription("Multi-Building Campus");
        loc.setLocationAddress("526 South Main Street Suite 609, Akron, OH 44311");
        loc.setLocationLatitude(41.071827);
        loc.setLocationLongitude(-81.527073);

        locationDao.addLocation(loc);

        Location fromDao = locationDao.getLocationById(loc.getLocationId());
        assertEquals(fromDao, loc);
    }

    @Test
    public void testDeleteLocation() {
        Location loc = new Location();
        loc.setLocationName("The Software Guild");
        loc.setLocationDescription("Multi-Building Campus");
        loc.setLocationAddress("526 South Main Street Suite 609, Akron, OH 44311");
        loc.setLocationLatitude(41.071827);
        loc.setLocationLongitude(-81.527073);

        locationDao.addLocation(loc);

        Location fromDao = locationDao.getLocationById(loc.getLocationId());
        assertEquals(fromDao, loc);

        locationDao.deleteLocation(loc.getLocationId());
        assertNull(locationDao.getLocationById(loc.getLocationId()));
    }

    @Test
    public void testAddUpdateLocation() {
        Location loc = new Location();
        loc.setLocationName("The Software Guild");
        loc.setLocationDescription("Multi-Building Campus");
        loc.setLocationAddress("526 South Main Street Suite 609, Akron, OH 44311");
        loc.setLocationLatitude(41.071827);
        loc.setLocationLongitude(-81.527073);

        locationDao.addLocation(loc);

        String akron = "The Software Guild";
        Location fromDao = locationDao.getLocationById(loc.getLocationId());
        assertEquals(fromDao.getLocationName(), akron);

        String minn = "The Software Guild Minnesota";

        fromDao.setLocationName("The Software Guild Minnesota");
        fromDao.setLocationDescription("Multi-Building Campus");
        fromDao.setLocationAddress("526 South Main Street Suite 609, Akron, OH 44311");
        fromDao.setLocationLatitude(41.071827);
        fromDao.setLocationLongitude(-81.527073);
        locationDao.updateLocation(fromDao);

        Location fromUpdateDao = locationDao.getLocationById(loc.getLocationId());
        assertEquals(fromUpdateDao.getLocationName(), minn);
    }

    @Test
    public void testGetAllLocations() {
        Location loc = new Location();
        loc.setLocationName("Metropolis");
        loc.setLocationDescription("City of Superman");
        loc.setLocationAddress("123 Metropolis Drive");
        loc.setLocationLatitude(42.98909);
        loc.setLocationLongitude(-81.234234);
        locationDao.addLocation(loc);

        Location locDos = new Location();
        locDos.setLocationName("Gotham");
        locDos.setLocationDescription("City of The Batman");
        locDos.setLocationAddress("456 Gotham Drive");
        locDos.setLocationLatitude(87.9847484);
        locDos.setLocationLongitude(-23.9898989);
        locationDao.addLocation(locDos);

        List<Location> locations = locationDao.getAllLocations();
        assertEquals(locations.size(), 2);
    }

    @Test
    public void testGetallLocationsBySuperId() {
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

        List<Location> superList = locationDao.getAllLocationsBySuperId(su.getSuperId());
        assertEquals(superList.size(), 1);
    }

}
