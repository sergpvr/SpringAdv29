package com.sergpvr.springadv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Serhiy_Povoroznyuk on 12/6/2017
 */
@Controller
public class DataBatchUploadController {
    @RequestMapping(value = "/dataBatchUpload", method = RequestMethod.GET)
    public String dataBatchUpload() {
        return "dataBatchUpload";
    }
}
