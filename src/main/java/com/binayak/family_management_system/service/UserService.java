package com.binayak.family_management_system.service;

import com.binayak.family_management_system.config.FileHandler;
import com.binayak.family_management_system.dto.request.LoginRequest;
import com.binayak.family_management_system.dto.request.UserRequest;
import com.binayak.family_management_system.entity.Users;
import com.binayak.family_management_system.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo repo;

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;


    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(UserRequest userRequest) throws IOException {
//        FileHandler fileHandler = new FileHandler();
        Users user = new Users();
//        String filepath = fileHandler.saveFile(userRequest.getProfilePhoto());
//        user.setImage(filepath);
        user.setEmail(userRequest.getEmail());
        user.setPassword(encoder.encode(userRequest.getPassword()));
//        user.setDob(userRequest.getDob());
//        user.setGender(userRequest.getGender());

        repo.save(user);
        return user;
    }


    public String verify(LoginRequest user) {
        Authentication authentication=authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(user.getEmail());
 
        return "Failure";

    }
}