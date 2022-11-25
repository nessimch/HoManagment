package com.ho.managment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @Value("${config.last_version:1.0}")
    private String lastVersion;

    @CrossOrigin(origins = "*")
    @GetMapping("last-version")
        public String lastVersion(){
        return lastVersion;
    }
}
