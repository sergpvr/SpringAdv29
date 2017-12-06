package com.sergpvr.springadv.controller;

import beans.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventControllerPdf {
    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/events", method = RequestMethod.GET, headers = "Accept=application/pdf")
    ModelAndView generatePdf() {
        ModelAndView modelAndView = new ModelAndView("pdfEventsView", "eventList", eventService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/events.pdf", method = RequestMethod.GET)
    ModelAndView generatePdf2() {
        return generatePdf();
    }
}
