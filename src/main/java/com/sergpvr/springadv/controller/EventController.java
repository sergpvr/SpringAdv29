package com.sergpvr.springadv.controller;

import beans.models.Auditorium;
import beans.models.Event;
import beans.models.Rate;
import beans.services.AuditoriumService;
import beans.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private AuditoriumService auditoriumService;

    @RequestMapping(value = "/events", method = RequestMethod.GET, headers="Accept=text/html")
    public String init(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("eventList", eventService.getAll());
        model.addAttribute("rateValues", Rate.values());
        model.addAttribute("auditoriumList", auditoriumService.getAuditoriums().stream().map(Auditorium::getName).collect(Collectors.toList()));
        return "events";
    }

    @RequestMapping(value = "/addEvent", method = RequestMethod.POST)
    public String addEvent(@RequestParam("name") String name, @RequestParam("rate") Rate rate, @RequestParam("basePrice") double basePrice,
                           @RequestParam("dateTime") LocalDateTime dateTime, @RequestParam("auditorium") String auditoriumName) {
        Event event = new Event();
        event.setName(name);
        event.setRate(rate);
        event.setBasePrice(basePrice);
        event.setDateTime(dateTime);
        event.setAuditorium(auditoriumService.getByName(auditoriumName));

        eventService.create(event);

        return "redirect:/events";
    }

    @RequestMapping(value = "/deleteEvent", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("eventId") long eventId) {
        eventService.remove(eventService.getById(eventId));

        return "redirect:/events";
    }
}
