/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero;

import com.sg.superhero.form.AddOrganizationForm;
import com.sg.superhero.model.Organization;
import com.sg.superhero.service.OrganizationService;
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
public class OrganizationController {

    OrganizationService organizationService;

    @Inject
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @RequestMapping(value = "/organizationAdd", method = RequestMethod.GET)
    public String displayAddOrganization(Model model) {
        List<Organization> organizationList = organizationService.getAllOrganizations();

        model.addAttribute("organizationList", organizationList);

        return "organizationAdd";
    }

    @RequestMapping(value = "/displayEditOrganization", method = RequestMethod.GET)
    public String displayEditOrganization(HttpServletRequest request, Model model) {

        String organizationId = request.getParameter("organizationId");
        Organization organization
                = organizationService
                        .getOrganizationById(Integer.parseInt(organizationId));
        model.addAttribute("organization", organization);

        return "organizationEdit";
    }

    @RequestMapping(value = "/editOrganization", method = RequestMethod.POST)
    public String displayEditOrganization(@Valid @ModelAttribute("organization") 
            Organization organizationId, BindingResult result, Model model) {

        if (result.hasErrors()) {
            List<Organization> organizationList = organizationService.getAllOrganizations();
            model.addAttribute("organizationList", organizationList);
            return "organization";
        }

        organizationService.updateOrganization(organizationId);

        List<Organization> organizationList = organizationService.getAllOrganizations();
        
        model.addAttribute("organizationList", organizationList);

        return "organization";
    }

    @RequestMapping(value = "/organizationAdd/add", method = RequestMethod.POST)
    public String createLocation(@ModelAttribute AddOrganizationForm orgForm) {
        //Follow testing for these methods!
        Organization org = new Organization();
        org.setOrganizationName(orgForm.getOrganizationName());
        org.setOrganizationDescription(orgForm.getOrganizationDescription());
        org.setOrganizationAddress(orgForm.getOrganizationAddress());
        org.setOrganizationPhone(orgForm.getOrganizationPhone());
        org.setOrganizationEmail(orgForm.getOrganizationEmail());

        organizationService.addOrganization(org);

        return "redirect:/organizationAdd";
    }

    @RequestMapping(value = "/organizationDelete", method = RequestMethod.GET)
    public String deleteOrganization(HttpServletRequest request) {

        String organizationIdParamater = request.getParameter("organizationId");

        organizationService.deleteOrganization(Integer.parseInt(organizationIdParamater));

        return "redirect:organization";
    }
}
