package com.sergpvr.springadv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RaiseExceptionController {
    @RequestMapping(value = "/raiseEx", method = RequestMethod.GET)
    public String raiseException() {
        if (true) {
            throw new RuntimeException("The Exception has raised from RaiseExceptionController for checking ...");
        }
        return "raiseException";
    }
}
