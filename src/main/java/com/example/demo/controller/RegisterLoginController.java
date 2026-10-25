package com.example.demo.controller;

import com.example.demo.domain.AppUser;
import com.example.demo.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RegisterLoginController {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public AppUser register(@RequestBody AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserRepository.save(appUser);
    }

    @GetMapping("/login")
    public String login(@RequestBody AppUser appUser) {
        var user = appUserRepository.findByUsername(appUser.getUsername());
        return user == null ? "NOT FOUND" : "SUCCESS";
    }
}
