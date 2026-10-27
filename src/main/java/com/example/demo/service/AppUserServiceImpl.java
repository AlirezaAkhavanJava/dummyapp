package com.example.demo.service;

import com.example.demo.domain.AppUser;
import com.example.demo.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AppUser register(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserRepository.save(appUser);
    }

    @Override
    public String login(AppUser appUser) {
        Authentication authentication =
                authenticationManager.authenticate
                        (
                                new UsernamePasswordAuthenticationToken(appUser.getUsername(), appUser.getPassword())
                        );
        return authentication.isAuthenticated() ? "NOT FOUND" : "TOKEN";
    }

}