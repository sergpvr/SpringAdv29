package com.sergpvr.springadv.controller;

import beans.models.Event;
import beans.models.Ticket;
import beans.services.BookingService;
import beans.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Serhiy_Povoroznyuk on 12/27/2017
 */
@Controller
@RequestMapping("/rtickets")
public class BookingControllerRest {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private EventService eventService;

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Ticket findTicket(@PathVariable("id") long id) {
        return bookingService.getAllTickets().stream().filter(t -> id == t.getId()).findFirst().orElse(null);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Ticket bookTicket(@RequestBody final Ticket model, HttpServletRequest request, HttpServletResponse response) {
        Ticket ticket = null;
        try {
            ticket = bookingService.bookTicket(model.getUser(), model);
        } catch (IllegalStateException ex) {}
        if (ticket != null) {
            response.setStatus(HttpStatus.CREATED.value());
        }
        return ticket;
    }

    @ResponseBody
    @RequestMapping(value="/all", method=RequestMethod.GET)
    public List<Ticket> getAllTickets() {
        return bookingService.getAllTickets();
    }

    @ResponseBody
    @RequestMapping(value = "/forEvent/{id}", method = RequestMethod.GET)
    public List<Ticket> getTicketForEvent(@PathVariable("id") long id) {
        Event event = eventService.getById(id);
        if(event == null) {
            return null;
        }
        return bookingService.getTicketsForEvent(event.getName(), event.getAuditorium().getName(), event.getDateTime());
    }
}
