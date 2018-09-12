/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero;

import com.sg.superhero.form.AddLocationForm;
import com.sg.superhero.model.Location;
import com.sg.superhero.model.Sighting;
import com.sg.superhero.model.SuperSighting;
import com.sg.superhero.service.LocationService;
import com.sg.superhero.service.SightingService;
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
public class LocationController {

    LocationService locationService;
    SightingService sightingService;
    SuperSightingService superSightingService;

    @Inject
    public LocationController(LocationService locationService, SightingService sightingService, SuperSightingService superSightingService) {
        this.locationService = locationService;
        this.sightingService = sightingService;
        this.superSightingService = superSightingService;
    }

    @RequestMapping(value = "/locationAdd", method = RequestMethod.GET)
    public String displayAddLocation(Model model) {

        List<Location> locationList = locationService.getAllLocations();

        model.addAttribute("locationList", locationList);

        return "locationAdd";
    }

    @RequestMapping(value = "/displayEditLocation", method = RequestMethod.GET)
    public String displayEditLocation(HttpServletRequest request, Model model) {

        String locationId = request.getParameter("locationId");
        Location location
                = locationService.getLocationById(Integer.parseInt(locationId));
        model.addAttribute("location", location);

        return "locationEdit";
    }

    @RequestMapping(value = "/editLocation", method = RequestMethod.POST)
    public String editLocation(@Valid @ModelAttribute("locationId") Location locationId,
            BindingResult result, Model model) {
        if (result.hasErrors()) {

            List<Location> locationList = locationService.getAllLocations();
            model.addAttribute("locationList", locationList);

            return "location";
        }

        locationService.updateLocation(locationId);

        List<Location> locationList = locationService.getAllLocations();

        model.addAttribute("locationList", locationList);

        return "location";
    }

    @RequestMapping(value = "/locationAdd/add", method = RequestMethod.POST)
    public String createLocation(AddLocationForm locationForm) {
        //Follow testing for these methods!
        Location loc = new Location();
        loc.setLocationName(locationForm.getLocationName());
        loc.setLocationDescription(locationForm.getLocationDescription());
        loc.setLocationAddress(locationForm.getLocationAddress());
        loc.setLocationLatitude(locationForm.getLocationLatitude());
        loc.setLocationLongitude(locationForm.getLocationlongitude());

        locationService.addLocation(loc);

        return "redirect:/locationAdd";
    }
    
    @RequestMapping(value = "/locationDelete", method = RequestMethod.GET)
    public String deleteLocation(HttpServletRequest request) {
    
        String locationIdParamater = request.getParameter("locationId");
        
//        List<SuperSighting> ssList = superSightingService.getAllSuperSightings();
        
        
        List<Sighting> sightinglist = sightingService
                .getAllSightingsByLocationId(Integer.parseInt(locationIdParamater));
        
        sightingService.deleteSighting(0);
        
        locationService.deleteLocation(Integer.parseInt(locationIdParamater));
        
        return "redirect:location";
    }

}
