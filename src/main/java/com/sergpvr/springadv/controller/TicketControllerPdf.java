package com.sergpvr.springadv.controller;

import beans.models.Ticket;
import beans.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TicketControllerPdf {
    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "/tickets", method = RequestMethod.GET, headers = "Accept=application/pdf")
    public ModelAndView generatePdf() {
        List<Ticket> tickets = bookingService.getAllTickets().stream()
                .sorted(Comparator.comparing(Ticket::getDateTime).thenComparing(Ticket::getPlace)
                ).collect(Collectors.toList());

        return new ModelAndView("pdfTicketsView", "ticketList", tickets);
    }

    @RequestMapping(value = "/tickets.pdf", method = RequestMethod.GET)
    ModelAndView generatePdf2() {
        return generatePdf();
    }
}
