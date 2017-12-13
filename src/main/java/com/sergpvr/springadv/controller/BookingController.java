package com.sergpvr.springadv.controller;

import beans.models.Event;
import beans.models.Ticket;
import beans.models.User;
import beans.services.AuditoriumService;
import beans.services.BookingService;
import beans.services.EventService;
import beans.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookingController {
    @Autowired
    private UserService userService;
    @Autowired
    private EventService eventService;
    @Autowired
    private AuditoriumService auditoriumService;
    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "tickets", method = RequestMethod.GET)
    public String tickets(@ModelAttribute("model") ModelMap model) {

        List<User> users = userService.getAll();
        if(CollectionUtils.isEmpty(users)) {
            return "redirect:/users";
        }
        List<Event> events = eventService.getAll();
        if(CollectionUtils.isEmpty(events)) {
            return "redirect:/events";
        }
        model.addAttribute("userList", users);
        model.addAttribute("eventList", events);
        List<Ticket> tickets = bookingService.getAllTickets().stream()
                .sorted(Comparator.comparing(Ticket::getDateTime).thenComparing(Ticket::getPlace))
                .collect(Collectors.toList());
        model.addAttribute("ticketList", tickets);
        return "tickets";
    }


    @RequestMapping(value = "/addTickets", method = RequestMethod.POST)
    public String addTickets(@RequestParam("userId") String userId, @RequestParam("eventId") String eventId,
                              @RequestParam("seats") String seats) {
        User user = userService.getById(Long.valueOf(userId));
        Event event = eventService.getById(Long.valueOf(eventId));
        Ticket ticket = new Ticket();
        ticket.setEvent(event);
        ticket.setSeats(seats);
        // problem with data models )
        ticket.setUser(user);
        ticket.setDateTime(ticket.getEvent().getDateTime());
        ticket.setPrice(bookingService.getTicketPrice(ticket.getEvent().getName(), ticket.getEvent().getAuditorium().getName(),
                ticket.getDateTime(), ticket.getSeatsList(), user));
        //

        bookingService.bookTicket(user, ticket);

        return "redirect:/tickets";
    }
}
