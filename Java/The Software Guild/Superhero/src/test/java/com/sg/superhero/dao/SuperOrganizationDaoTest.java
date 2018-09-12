/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.dao;

import com.sg.superhero.model.Organization;
import com.sg.superhero.model.Super;
import com.sg.superhero.model.SuperOrganization;
import com.sg.superhero.model.SuperPower;
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
public class SuperOrganizationDaoTest {

    SuperOrganizationDao superOrganizationDao;
    SuperDao superDao;
    OrganizationDao organizationDao;
    SuperSightingDao superSightingDao;
    SuperPowerDao superPowerDao;

    public SuperOrganizationDaoTest() {
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
        superOrganizationDao
                = ctx.getBean("superOrganizationDao", SuperOrganizationDao.class);
        organizationDao
                = ctx.getBean("organizationDao", OrganizationDao.class);
        superDao = ctx.getBean("superDao", SuperDao.class);
        superPowerDao = ctx.getBean("superPowerDao", SuperPowerDao.class);

        List<SuperOrganization> superOrgs
                = superOrganizationDao.getAllSuperOrganizations();
        if (superOrgs != null) {
            for (SuperOrganization currentSuperOrg : superOrgs) {
                superOrganizationDao
                        .deleteSuperOrganization(
                                currentSuperOrg.getSuperOrganizationId());
            }
        }
    }

    @After
    public void tearDown() {
        List<SuperOrganization> superOrgs
                = superOrganizationDao.getAllSuperOrganizations();
        if (superOrgs != null) {
            for (SuperOrganization currentSuperOrg : superOrgs) {
                superOrganizationDao
                        .deleteSuperOrganization(
                                currentSuperOrg.getSuperOrganizationId());
            }
        }
    }

    @Test
    public void addGetSuperOrganization() {
        Organization org = new Organization();
        org.setOrganizationName("The Software Guild");
        org.setOrganizationDescription("Multi Building");
        org.setOrganizationAddress("123 Wrong Way BLVD");
        org.setOrganizationPhone("6149999999");
        org.setOrganizationEmail("PToner@SG.com");

        organizationDao.addOrganization(org);

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

        SuperOrganization sOrg = new SuperOrganization();
        sOrg.setOrganization(org);
        sOrg.setSuperHuman(su);

        superOrganizationDao.addSuperOrganization(sOrg);

        SuperOrganization fromDao
                = superOrganizationDao.getSuperOrganizationById(
                        sOrg.getSuperOrganizationId());
        assertEquals(fromDao, sOrg);
    }

    @Test
    public void deleteSuperOrganization() {
        Organization org = new Organization();
        org.setOrganizationName("The Software Guild");
        org.setOrganizationDescription("Multi Building");
        org.setOrganizationAddress("123 Wrong Way BLVD");
        org.setOrganizationPhone("6149999999");
        org.setOrganizationEmail("PToner@SG.com");

        organizationDao.addOrganization(org);

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

        SuperOrganization sOrg = new SuperOrganization();
        sOrg.setOrganization(org);
        sOrg.setSuperHuman(su);

        superOrganizationDao.addSuperOrganization(sOrg);

        SuperOrganization fromDao
                = superOrganizationDao.getSuperOrganizationById(
                        sOrg.getSuperOrganizationId());
        assertEquals(fromDao, sOrg);

        superOrganizationDao.deleteSuperOrganization(
                sOrg.getSuperOrganizationId());
        assertNull(superOrganizationDao
                .getSuperOrganizationById(sOrg.getSuperOrganizationId()));
    }

    @Test
    public void testAddUpdateSuperOrganization() {
        Organization org = new Organization();
        org.setOrganizationName("The Software Guild");
        org.setOrganizationDescription("Multi Building");
        org.setOrganizationAddress("123 Wrong Way BLVD");
        org.setOrganizationPhone("6149999999");
        org.setOrganizationEmail("PToner@SG.com");

        organizationDao.addOrganization(org);

        String orgName = "The Software Guild";
        Organization fromOrgDao = organizationDao.getOrganizationById(org.getOrganizationId());
        assertEquals(fromOrgDao, org);

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

        SuperOrganization sOrg = new SuperOrganization();
        sOrg.setOrganization(org);
        sOrg.setSuperHuman(su);

        superOrganizationDao.addSuperOrganization(sOrg);

        SuperOrganization fromDao
                = superOrganizationDao.getSuperOrganizationById(
                        sOrg.getSuperOrganizationId());
        assertEquals(fromDao, sOrg);
    }

    @Test
    public void getAllSuperOrganizations() {
        Organization org = new Organization();
        org.setOrganizationName("The Software Guild");
        org.setOrganizationDescription("Multi Building");
        org.setOrganizationAddress("123 Wrong Way BLVD");
        org.setOrganizationPhone("6149999999");
        org.setOrganizationEmail("PToner@SG.com");

        organizationDao.addOrganization(org);

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

        SuperOrganization sOrg = new SuperOrganization();
        sOrg.setOrganization(org);
        sOrg.setSuperHuman(su);

        superOrganizationDao.addSuperOrganization(sOrg);

        SuperOrganization fromDao
                = superOrganizationDao.getSuperOrganizationById(
                        sOrg.getSuperOrganizationId());
        assertEquals(fromDao, sOrg);

        List<SuperOrganization> superOrganizationsList
                = superOrganizationDao.getAllSuperOrganizations();
        assertEquals(superOrganizationsList.size(), 1);
    }
}
