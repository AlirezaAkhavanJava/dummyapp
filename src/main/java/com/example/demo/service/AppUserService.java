package com.example.demo.service;

import com.example.demo.domain.AppUser;

public interface AppUserService {
    AppUser register(AppUser appUser);
    String login(AppUser appUser);
}
