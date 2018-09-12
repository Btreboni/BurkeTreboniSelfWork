/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.model.Super;
import com.sg.superhero.model.SuperOrganization;
import com.sg.superhero.model.SuperPower;
import com.sg.superhero.model.SuperSighting;
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
public class SuperPowerDaoTest {

    SuperPowerDao superPowerDao;
    SuperDao superDao;
    SuperOrganizationDao superOrganizationDao;
    SuperSightingDao superSightingDao;

    public SuperPowerDaoTest() {
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
        superPowerDao = ctx.getBean("superPowerDao", SuperPowerDao.class);
        superDao = ctx.getBean("superDao", SuperDao.class);
        superOrganizationDao
                = ctx.getBean("superOrganizationDao", SuperOrganizationDao.class);
        superSightingDao = ctx.getBean("superSightingDao", SuperSightingDao.class);

        List<SuperSighting> supersight = superSightingDao.getAllSuperSightings();
        if (supersight != null) {
            for (SuperSighting currentSuperSighting : supersight) {
                superSightingDao
                        .deleteSuperSighting(currentSuperSighting.getSuperSightingId());
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

        List<Super> sup = superDao.getAllSupers();
        if (sup != null) {
            for (Super currentSuper : sup) {
                superDao.deleteSuper(currentSuper.getSuperId());
            }
        }
        List<SuperPower> sPower = superPowerDao.getAllSuperPowers();
        if (sPower != null) {
            for (SuperPower currentSuperPower : sPower) {
                superPowerDao
                        .deleteSuperPower(
                                currentSuperPower.getSuperPowerId());
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

        List<SuperOrganization> superOrgs
                = superOrganizationDao.getAllSuperOrganizations();
        if (superOrgs != null) {
            for (SuperOrganization currentSuperOrg : superOrgs) {
                superOrganizationDao
                        .deleteSuperOrganization(
                                currentSuperOrg.getSuperOrganizationId());
            }
        }

        List<Super> sup = superDao.getAllSupers();
        if (sup != null) {
            for (Super currentSuper : sup) {
                superDao.deleteSuper(currentSuper.getSuperId());
            }
        }
        List<SuperPower> sPower = superPowerDao.getAllSuperPowers();
        if (sPower != null) {
            for (SuperPower currentSuperPower : sPower) {
                superPowerDao
                        .deleteSuperPower(
                                currentSuperPower.getSuperPowerId());
            }
        }
    }

    @Test
    public void addGetSuperPower() {
        SuperPower sPower = new SuperPower();
        sPower.setSuperPowerName("Invisible");

        superPowerDao.addSuperPower(sPower);

        SuperPower fromDao = superPowerDao
                .getSuperPowerById(sPower.getSuperPowerId());
        assertEquals(fromDao, sPower);
    }

    @Test
    public void deleteSuperPower() {
        SuperPower sPower = new SuperPower();
        sPower.setSuperPowerName("Invisible");

        superPowerDao.addSuperPower(sPower);

        SuperPower fromDao = superPowerDao
                .getSuperPowerById(sPower.getSuperPowerId());
        assertEquals(fromDao, sPower);

        superPowerDao.deleteSuperPower(sPower.getSuperPowerId());
        assertNull(superPowerDao.getSuperPowerById(sPower.getSuperPowerId()));
    }

    @Test
    public void testAddUpdateSuperPower() {
        SuperPower sPower = new SuperPower();
        sPower.setSuperPowerName("Invisible");

        superPowerDao.addSuperPower(sPower);

        String invisible = "Invisible";
        SuperPower fromDao = superPowerDao
                .getSuperPowerById(sPower.getSuperPowerId());
        assertEquals(fromDao.getSuperPowerName(), invisible);

        String flight = "Flight";
        fromDao.setSuperPowerName(flight);

        superPowerDao.updateSuperPower(fromDao);

        SuperPower fromUpdateDao = superPowerDao.getSuperPowerById(sPower.getSuperPowerId());
        assertEquals(fromUpdateDao.getSuperPowerName(), flight);
    }

    @Test
    public void testGetAllSuperPowers() {
        // Make first object
        SuperPower sPower = new SuperPower();
        sPower.setSuperPowerName("Invisible");

        superPowerDao.addSuperPower(sPower);

        SuperPower fromDao = superPowerDao
                .getSuperPowerById(sPower.getSuperPowerId());
        assertEquals(fromDao, sPower);

        // Make second object
        SuperPower sPower2 = new SuperPower();
        sPower2.setSuperPowerName("Flight");

        superPowerDao.addSuperPower(sPower2);

        SuperPower fromDao2 = superPowerDao
                .getSuperPowerById(sPower2.getSuperPowerId());
        assertEquals(fromDao2, sPower2);
        
        List<SuperPower> superPowerList = superPowerDao.getAllSuperPowers();
        assertEquals(superPowerList.size(), 2);
    }
}
