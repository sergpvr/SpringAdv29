package com.sergpvr.springadv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @RequestMapping(value={"/", "login"}, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value="error", required=false) Boolean error) {
        ModelAndView model = new ModelAndView("login");
        model.addObject("error", error==null? Boolean.FALSE : error);
        return model;
    }
}
