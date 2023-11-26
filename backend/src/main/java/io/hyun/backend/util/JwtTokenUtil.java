package io.hyun.backend.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {
    private static final String SECRET_KEY = "qwer1234";

    public String jwtCreate(String userEmail) {
        return Jwts.builder()
                .setSubject(userEmail)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
