/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero;

import com.sg.superhero.form.AddSuperForm;
import com.sg.superhero.model.Organization;
import com.sg.superhero.model.Super;
import com.sg.superhero.model.SuperHeroOrgList;
import com.sg.superhero.model.SuperOrganization;
import com.sg.superhero.model.SuperPower;
import com.sg.superhero.service.OrganizationService;
import com.sg.superhero.service.SuperOrganizationService;
import com.sg.superhero.service.SuperPowerService;
import com.sg.superhero.service.SuperService;
import com.sg.superhero.service.SuperSightingService;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Burke Treboni
 */
@Controller
public class SuperController {

    SuperService superService;
    SuperPowerService superPowerService;
    OrganizationService orgService;
    SuperOrganizationService superOrgService;
    SuperSightingService superSightingService;

    //USE YOUR TESTING!!
    @Inject
    public SuperController(SuperService superService, SuperPowerService superPowerService, OrganizationService orgService, SuperOrganizationService superOrgService, SuperSightingService superSightingService) {
        this.superService = superService;
        this.superPowerService = superPowerService;
        this.orgService = orgService;
        this.superOrgService = superOrgService;
        this.superSightingService = superSightingService;
    }

    @RequestMapping(value = "displayEditSuper", method = RequestMethod.GET)
    public String displayEditSuper(HttpServletRequest request, Model model) {

        String superId = request.getParameter("superId");
        Super hero = superService.getSuperById(Integer.parseInt(superId));
        model.addAttribute("hero", hero);

        List<SuperPower> sPowerList = superPowerService.getAllSuperPowers();
        model.addAttribute("sPowerList", sPowerList);

        List<Organization> orgList = orgService.getAllOrganizations();
        model.addAttribute("orgList", orgList);

        return "superEdit";
    }

    @RequestMapping(value = "/editSuper", method = RequestMethod.POST)
    public String displaySuperEdit(SuperHeroOrgList hero) {

        Super sup = superService.getSuperById(hero.getSuperId());
        SuperOrganization sOrg = superOrgService.getSuperOrganizationBySuperId(hero.getSuperId());
        
        sup.setSuperDescription(hero.getSuperDescription());
        sup.setSuperPower(superPowerService.getSuperPowerBySuperId(hero.getSuperId()));
        sOrg.setOrganization(orgService.getOrganizationById(hero.getOrganizationId()));
        
        superService.updateSuper(sup);
        superOrgService.updateSuperOrganization(sOrg);

        return "redirect:/super";
    }

    @RequestMapping(value = "/displaySuperPage", method = RequestMethod.GET)
    public String displaySuperPage(Model model) {

        List<SuperHeroOrgList> shoList = superService.loadSuperHeros();

//        List<Super> superList = superService.getAllSupers();

//        for (Super sup : superList) {
//            sup.setSuperPower(superPowerService
//                    .getSuperPowerById(sup.getSuperPower()
//                            .getSuperPowerId()));
//
//        }
        List<SuperPower> powerList = superPowerService.getAllSuperPowers();
        List<Organization> organizationList = orgService.getAllOrganizations();

//        for (SuperOrganization sOrg : organizationList) {
//            sOrg.setOrganization(orgService.getOrganizationById(sOrg.getOrganization().getOrganizationId()));
//        }

        model.addAttribute("shoList", shoList);
//        model.addAttribute("superList", superList);
        model.addAttribute("powerList", powerList);
        model.addAttribute("organizationList", organizationList);

        return "superAdd";
    }

    @RequestMapping(value = "/superAdd/add", method = RequestMethod.POST)
    public String createSuper(AddSuperForm superForm) {
        //Follow testing for these methods!
        
        SuperPower power = superPowerService.getSuperPowerById(superForm.getSuperPowerId());

        Super hero = new Super();
        hero.setSuperName(superForm.getSuperName());
        hero.setSuperDescription(superForm.getSuperDescription());
        hero.setSuperPower(power);
        superService.addSuper(hero);
        
        Organization org = orgService.getOrganizationById(superForm.getOrganizationId());

        SuperOrganization sorg = new SuperOrganization();
        sorg.setSuperHuman(hero);
        sorg.setOrganization(org);
        superOrgService.addSuperOrganization(sorg);

        return "redirect:/displaySuperPage";
    }

    @RequestMapping(value = "/superDelete", method = RequestMethod.GET)
    public String deleteSuper(HttpServletRequest request) {

        String superIdParameter = request.getParameter("superId");

        superService.deleteSuper(Integer.parseInt(superIdParameter));

        return "redirect:/super";
    }
}
