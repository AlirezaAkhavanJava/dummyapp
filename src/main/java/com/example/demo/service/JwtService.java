package com.example.demo.service;


import com.example.demo.domain.AppUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private String SECRET_KEY = null;

    public String generateToken(AppUser appUser) {
        Map<String, Object> claims = new HashMap<>();

        return Jwts
                .builder()
                .claims()
                .add(claims)
                .subject(appUser.getUsername())
                .issuer("ALIREZA")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 10 * 1000))
                .and()
                .signWith(generateKey())
                .compact();

    }

    private SecretKey generateKey() {
        byte[] decode
                = Decoders.BASE64.decode(getSECRET_KEY());
        return Keys.hmacShaKeyFor(decode);
    }

    public String getSECRET_KEY() {
        return SECRET_KEY = "1lq3XWQGqcaLIXE+vthKUxRleUF7ol5v6CBqdH6GXYU=";
    }

    public String extractUserName() {
        return "";
    }

    public boolean isTokenValid(String jwt, UserDetails userDetails) {
        return true;
    }
}
