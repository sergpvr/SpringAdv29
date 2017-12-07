package com.sergpvr.springadv.controller;

import beans.models.GroupModel;
import beans.services.AuditoriumService;
import beans.services.EventService;
import beans.services.ParserService;
import beans.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class FileUploadController {

    private ParserService parserService = new ParserService();

    @Autowired
    private UserService userService;
    @Autowired
    private EventService eventService;
    @Autowired
    private AuditoriumService auditoriumService;

    @RequestMapping(value = "/uploadDataFile", method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException, JAXBException {

        GroupModel groupModel =  parserService.fromXML(file.getInputStream());
        if (groupModel.getUsers() != null) {
            groupModel.getUsers().stream().forEach(u -> userService.register(u));
        }
        if (groupModel.getEvents() != null) {
            groupModel.getEvents().stream().forEach(e -> {
                e.setAuditorium(auditoriumService.getByName(e.getAuditorium().getName()));
                eventService.create(e);
            });
        }

        return "File has been uploaded";
    }
}
