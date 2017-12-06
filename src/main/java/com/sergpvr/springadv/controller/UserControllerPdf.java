package com.sergpvr.springadv.controller;

import beans.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserControllerPdf {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET, headers = "Accept=application/pdf")
    public ModelAndView generatePdf() {
        ModelAndView modelAndView = new ModelAndView("pdfUsersView", "userList", userService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/users.pdf", method = RequestMethod.GET)
    public ModelAndView generatePdf2() {
        return generatePdf();
    }
}
