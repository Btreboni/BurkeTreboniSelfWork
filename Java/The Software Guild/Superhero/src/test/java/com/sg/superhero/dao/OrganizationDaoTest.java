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
public class OrganizationDaoTest {

    SuperOrganizationDao superOrganizationDao;
    OrganizationDao organizationDao;
    SuperDao superDao;
    SuperPowerDao superPowerDao;

    public OrganizationDaoTest() {
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
        superOrganizationDao = ctx.getBean("superOrganizationDao", SuperOrganizationDao.class);
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

        List<Organization> orgs = organizationDao.getAllOrganizations();
        if (orgs != null) {
            for (Organization currentOrganization : orgs) {
                organizationDao.deleteOrganization(currentOrganization.getOrganizationId());
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

        List<Organization> orgs = organizationDao.getAllOrganizations();
        if (orgs != null) {
            for (Organization currentOrganization : orgs) {
                organizationDao.deleteOrganization(currentOrganization.getOrganizationId());
            }
        }
    }

    @Test
    public void addGetOrganization() {
        Organization org = new Organization();
        org.setOrganizationName("The Software Guild");
        org.setOrganizationDescription("Multi Building");
        org.setOrganizationAddress("123 Wrong Way BLVD");
        org.setOrganizationPhone("6149999999");
        org.setOrganizationEmail("PToner@SG.com");

        organizationDao.addOrganization(org);

        Organization fromDao = organizationDao.getOrganizationById(org.getOrganizationId());
        assertEquals(fromDao, org);
    }

    @Test
    public void deleteOrganization() {
        Organization org = new Organization();
        org.setOrganizationName("The Software Guild");
        org.setOrganizationDescription("Multi Building");
        org.setOrganizationAddress("123 Wrong Way BLVD");
        org.setOrganizationPhone("6149999999");
        org.setOrganizationEmail("PToner@SG.com");

        organizationDao.addOrganization(org);

        Organization fromDao = organizationDao.getOrganizationById(org.getOrganizationId());
        assertEquals(fromDao, org);

        organizationDao.deleteOrganization(org.getOrganizationId());
        assertNull(organizationDao.getOrganizationById(org.getOrganizationId()));
    }

    @Test
    public void upTestAddUpdate() {
        Organization org = new Organization();
        org.setOrganizationName("The Software Guild");
        org.setOrganizationDescription("Multi Building");
        org.setOrganizationAddress("123 Wrong Way BLVD");
        org.setOrganizationPhone("6149999999");
        org.setOrganizationEmail("PToner@SG.com");

        organizationDao.addOrganization(org);

        String akron = "The Software Guild";
        Organization fromDao = organizationDao.getOrganizationById(org.getOrganizationId());
        assertEquals(fromDao.getOrganizationName(), akron);

        String minn = "The Software Guild Minnesota";

        fromDao.setOrganizationName(minn);
        fromDao.setOrganizationDescription("Multi Building");
        fromDao.setOrganizationAddress("123 Wrong Way BLVD");
        fromDao.setOrganizationPhone("6149999999");
        fromDao.setOrganizationEmail("PToner@SG.com");
        organizationDao.updateOrganization(fromDao);

        Organization fromUpdateDao = organizationDao.getOrganizationById(org.getOrganizationId());
        assertEquals(fromUpdateDao.getOrganizationName(), minn);
    }

    @Test
    public void getAllOrganizations() {

        Organization org = new Organization();
        org.setOrganizationName("Zod");
        org.setOrganizationDescription("Order of Zod");
        org.setOrganizationAddress("123 Evil Lane");
        org.setOrganizationPhone("6148478474");
        org.setOrganizationEmail("bigZOD@myZod.com");
        organizationDao.addOrganization(org);

        Organization org2 = new Organization();
        org2.setOrganizationName("LexCorp");
        org2.setOrganizationDescription("Lex Luthor Incorportated");
        org2.setOrganizationAddress("666 Luxury Lane");
        org2.setOrganizationPhone("9890998987");
        org2.setOrganizationEmail("lilLex@luthor.com");
        organizationDao.addOrganization(org2);

        Organization org3 = new Organization();
        org3.setOrganizationName("Legion of Doom");
        org3.setOrganizationDescription("These are some bad guys");
        org3.setOrganizationAddress("12 Doomed Drive");
        org3.setOrganizationPhone("1231231233");
        org3.setOrganizationEmail("LegionOfDoom@LOD.com");
        organizationDao.addOrganization(org3);

        List<Organization> organization = organizationDao.getAllOrganizations();
        assertEquals(organization.size(), 3);
    }

    @Test
    public void getAllOrganizationsBySuper() {

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

        List<Organization> orgList = organizationDao.getAllOrganizationsBySuper(su.getSuperId());
        assertEquals(orgList.size(), 1);
    }
}
