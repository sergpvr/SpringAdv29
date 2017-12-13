package com.sergpvr.springadv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getRoot() {
        return "redirect:/tickets";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView getLoginForm(@RequestParam(required=false)  String authfailed, String logout,
                              String denied) {

        String message = "";
        if (authfailed != null) {
            message = "Invalid username of password, try again !";
        } else if (logout != null) {
            message = "Logged Out successfully, login again to continue !";
        } else if (denied != null) {
            message = "Access denied for this user !";
        }
        return new ModelAndView("login", "message", message);
    }

    @RequestMapping("/403page")
    public String get403denied() {
        return "redirect:login?denied";
    }
}
