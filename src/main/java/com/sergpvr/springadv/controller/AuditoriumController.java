package com.sergpvr.springadv.controller;

import beans.services.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuditoriumController {
    @Autowired
    private AuditoriumService auditoriumService;

    @RequestMapping(value = "/auditoriums", method = RequestMethod.GET)
    public String getAuditoriums(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("auditoriumList", auditoriumService.getAuditoriums());
        return "auditoriums";
    }
}
