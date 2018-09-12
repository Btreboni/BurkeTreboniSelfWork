/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero;

import com.sg.superhero.form.AddSightingForm;
import com.sg.superhero.model.Location;
import com.sg.superhero.model.Organization;
import com.sg.superhero.model.Sighting;
import com.sg.superhero.model.Super;
import com.sg.superhero.model.SuperHeroSighting;
import com.sg.superhero.model.SuperSighting;
import com.sg.superhero.service.LocationService;
import com.sg.superhero.service.OrganizationService;
import com.sg.superhero.service.SightingService;
import com.sg.superhero.service.SuperService;
import com.sg.superhero.service.SuperSightingService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class SightingController {

    SightingService sightingService;
    OrganizationService organizationService;
    SuperService superService;
    LocationService locationService;
    SuperSightingService superSightingService;

    @Inject
    public SightingController(SightingService sightingService, OrganizationService organizationService, SuperService superService, LocationService locationService, SuperSightingService superSightingService) {
        this.sightingService = sightingService;
        this.organizationService = organizationService;
        this.superService = superService;
        this.locationService = locationService;
        this.superSightingService = superSightingService;
    }

    @RequestMapping(value = "/sightingAdd", method = RequestMethod.GET)
    public String displayAddSighting(Model model) {

        List<SuperHeroSighting> sightingList = sightingService.getAllSightingsByDate();
        List<Super> superList = superService.getAllSupers();
        List<Location> locationList = locationService.getAllLocations();

        model.addAttribute("sightingList", sightingList);
        model.addAttribute("superList", superList);
        model.addAttribute("locationList", locationList);

        return "sightingAdd";
    }

    @RequestMapping(value = "/sightingAdd/add", method = RequestMethod.POST)
    public String createSighting(AddSightingForm sightingForm) {

        Location location = locationService.getLocationById(sightingForm.getLocationId());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Sighting sighting = new Sighting();
        sighting.setSightingDate(LocalDate.parse(sightingForm.getSightingDate(), dtf));
        sighting.setLocation(location);

        sightingService.addSighting(sighting);

        Super sup = superService.getSuperById(sightingForm.getSuperId());

        SuperSighting ss = new SuperSighting();
        ss.setSuperHuman(sup);
        ss.setSighting(sighting);
        superSightingService.addSuperSighting(ss);

        return "redirect:/sightingAdd";
    }

    @RequestMapping(value = "/sightingDelete", method = RequestMethod.GET)
    public String deleteLocation(HttpServletRequest request) {

        String sightingIdParameter = request.getParameter("sightingId");

//        superSightingService.deleteSuperSighting(Integer.parseInt(sightingIdParameter));
        sightingService.deleteSighting(Integer.parseInt(sightingIdParameter));

        return "redirect:/sightingAdd";
    }

    @RequestMapping(value = "/displayEditSighting", method = RequestMethod.GET)
    public String displayEditLocation(HttpServletRequest request, Model model) {

        String sightingId = request.getParameter("sightingId");
        Sighting sighting
                = sightingService.getSightingById(Integer.parseInt(sightingId));
        model.addAttribute("sighting", sighting);

        List<Location> locationList = locationService.getAllLocations();
        model.addAttribute("locationList", locationList);

        List<Super> superList = superService.getAllSupers();
        model.addAttribute("superList", superList);

        return "sightingEdit";
    }

    @RequestMapping(value = "/editSighting", method = RequestMethod.POST)
    public String editLocation(SuperHeroSighting sighting) {
//        if (result.hasErrors()) {
//
//            return "redirect:/sighting";
//        }

        Sighting see = sightingService.getSightingById(sighting.getSightingId());
        SuperSighting ss = superSightingService.getSuperSightingBySightingId(sighting.getSightingId());

        see.setSightingDate(sighting.getSightingDate());
        ss.setSuperHuman(superService.getSuperById(sighting.getSuperId()));
        see.setLocation(locationService.getLocationById(sighting.getLocationId()));

        sightingService.updateSighting(see);
        superSightingService.updateSuperSighting(ss);

//        //get location by sighting id
//        Location location = sightingService.getLocationBySightingID(sightingId.getLocationId());
//        //get org by sighting id
//        Organization org = sightingService.getOrganizationBySightingID(sightingId.getOrganizationId());
//        //getsup by sighting id
//        Super sup = sightingService.getSuperBySightingID(sightingId.getSuperId());
//        //get sighting  by sighting id
//        Sighting sight = sightingService.getSightingById(sightingId.getSighting().getSightingId());
//        
//        locationService.updateLocation(location);
//        organizationService.updateOrganization(org);
//        superService.updateSuper(sup);
//        sightingService.updateSighting(sightingId);
//        superSightingService.updateSuperSighting(sightingId);
//        List<SuperHeroSighting> sightingList = sightingService.getAllSightingsByDate();
//        model.addAttribute("sightingList", sightingList);
        return "redirect:/sighting";
    }
}
