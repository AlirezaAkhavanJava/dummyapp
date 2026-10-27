package com.example.demo.service;

import com.example.demo.domain.AppUser;
import com.example.demo.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AppUser register(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserRepository.save(appUser);
    }

    @Override
    public String login(AppUser appUser) {
        return null;
    }


    public String verify(AppUser appUser) {
        var user = appUserRepository.findByUsername(appUser.getUsername());
        return user == null ? "NOT FOUND" : "SUCCESS";
    }
}