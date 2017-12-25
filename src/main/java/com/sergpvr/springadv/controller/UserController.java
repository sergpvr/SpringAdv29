package com.sergpvr.springadv.controller;

import beans.models.User;
import beans.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @RequestMapping(value = "/users", method = RequestMethod.GET, headers="Accept=text/html")
    public String getUsers(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("userList", userService.getAll());
        //model.addAttribute("userAccounts", userService.getUserAccounts());
        return "users";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.register(user);

        return "redirect:/users";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("userId") long userId) {
        userService.remove(userService.getById(userId));

        return "redirect:/users";
    }

    @RequestMapping(value = {"/getUsersByParam/", "/getUsersByParam"}, method = RequestMethod.GET)
    public String getUsersByParam(@ModelAttribute("model") ModelMap model,
                                  @RequestParam Map<String,String> allRequestParams) {

        List<User> users = new ArrayList<>();

        if(allRequestParams.containsKey("name")) {
            users.addAll(userService.getUsersByName(allRequestParams.get("name")));
        } else if (allRequestParams.containsKey("email")) {
            User user = userService.getUserByEmail(allRequestParams.get("email"));
            if (user != null) {
                users.add(user);
            }
        }

        model.addAttribute("userList", users);
        return "users";
    }

    @RequestMapping(value = "/refillAccount", method = RequestMethod.POST)
    public String refillAccount(@RequestParam("userId") long userId, @RequestParam("amount") double amount) {
        userService.refillAccount(userId, amount);

        return "redirect:/users";
    }


}
