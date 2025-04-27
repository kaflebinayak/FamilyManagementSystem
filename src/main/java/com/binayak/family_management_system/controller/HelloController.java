package com.binayak.family_management_system.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @CrossOrigin(origins = "*")
    @GetMapping("")
    public String Greet(HttpServletRequest request){
        return "Hello World" + request.getSession().getId();

    }
}
