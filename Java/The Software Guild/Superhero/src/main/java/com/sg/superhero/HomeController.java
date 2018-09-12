/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero;

import com.sg.superhero.model.Location;
import com.sg.superhero.model.Organization;
import com.sg.superhero.model.Sighting;
import com.sg.superhero.model.Super;
import com.sg.superhero.model.SuperHeroOrgList;
import com.sg.superhero.model.SuperHeroSighting;
import com.sg.superhero.model.SuperOrganization;
import com.sg.superhero.model.SuperPower;
import com.sg.superhero.model.SuperSighting;
import com.sg.superhero.service.LocationService;
import com.sg.superhero.service.OrganizationService;
import com.sg.superhero.service.SightingService;
import com.sg.superhero.service.SuperOrganizationService;
import com.sg.superhero.service.SuperPowerService;
import com.sg.superhero.service.SuperService;
import com.sg.superhero.service.SuperSightingService;
import java.time.LocalDate;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Burke Treboni
 */
@Controller
public class HomeController {

    SuperService superService;
    SuperSightingService superSight;
    OrganizationService organizationService;
    SuperPowerService superPowerService;
    SightingService sightingService;
    LocationService locationService;
    SuperOrganizationService superOrganizationService;

    @Inject
    public HomeController(SuperService superService, SuperSightingService superSight, OrganizationService organizationService, SuperPowerService superPowerService, SightingService sightingService, LocationService locationService, SuperOrganizationService superOrganizationService) {
        this.superService = superService;
        this.superSight = superSight;
        this.organizationService = organizationService;
        this.superPowerService = superPowerService;
        this.sightingService = sightingService;
        this.locationService = locationService;
        this.superOrganizationService = superOrganizationService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayHomePage(Model model) {
        List<SuperHeroSighting> sightingList = sightingService.getAllSightingsByDate();

        model.addAttribute("sightingList", sightingList);

        return "home";
    }

    @RequestMapping(value = "displaySightingDetails", method = RequestMethod.GET)
    public String displaySightingDetails(HttpServletRequest request, Model model) {
        String sightingIdParameter = request.getParameter("sightingId");
        int sightingId = Integer.parseInt(sightingIdParameter);

        SuperSighting superSighting = superSight.getSuperSightingById(sightingId);

        model.addAttribute("superSighing", superSighting);

        return "sightingDetails";
    }

    @RequestMapping(value = "/super", method = RequestMethod.GET)
    public String displaySuper(Model model) {

        List<SuperHeroOrgList> superList = superService.loadSuperHeros();

        model.addAttribute("superList", superList);

        return "super";
    }

    @RequestMapping(value = "/organization", method = RequestMethod.GET)
    public String displayOrganization(Model model) {
        List<Organization> organizationList = organizationService.getAllOrganizations();

        model.addAttribute("organizationList", organizationList);

        return "organization";
    }

    @RequestMapping(value = "/sighting", method = RequestMethod.GET)
    public String displaySighting(Model model) {
        List<SuperHeroSighting> sightingList = sightingService.getAllSightingsByDate();

        model.addAttribute("sightingList", sightingList);

        return "sighting";
    }

    @RequestMapping(value = "/location", method = RequestMethod.GET)
    public String displayLocation(Model model) {
        List<Location> locationList = locationService.getAllLocations();

        model.addAttribute("locationList", locationList);

        return "location";
    }

    @RequestMapping(value = "/populateEditPage", method = RequestMethod.GET)
    public String displayEditSighting() {

        return "redirect:sightingEdit";
    }

}
