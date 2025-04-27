package com.binayak.family_management_system.controller;

import com.binayak.family_management_system.dto.request.UserRequest;
import com.binayak.family_management_system.entity.Users;
import com.binayak.family_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserService service;

    private BCryptPasswordEncoder encoder =new BCryptPasswordEncoder(12);

    @PostMapping("/register")
    public Users register(@RequestBody UserRequest user) throws IOException {
        return service.register(user);
    }

    @PostMapping("/login")
    public String login (@RequestBody UserRequest user){

        return service.verify(user);

    }

}
