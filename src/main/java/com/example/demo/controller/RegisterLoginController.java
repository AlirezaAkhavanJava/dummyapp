package com.example.demo.controller;

import com.example.demo.domain.AppUser;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RegisterLoginController {

    private final AppUserService appUserService;


    @PostMapping("/register")
    public AppUser register(@RequestBody AppUser appUser) {
        return appUserService.register(appUser);
    }

    @GetMapping("/login")
    public String login(@RequestBody AppUser appUser) {
        return appUserService.login(appUser);
    }
}
