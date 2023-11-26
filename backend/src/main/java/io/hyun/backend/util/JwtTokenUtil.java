package io.hyun.backend.util;

import io.hyun.backend.entities.User;
import io.hyun.backend.entities.dto.authDto.ResponseLoginDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {
    private static final String SECURITY_KEY ="hyunhyun";

    public String create(String userEmail) {
        Date exprTime = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECURITY_KEY)
                .setSubject(userEmail)
                .setIssuedAt(new Date())
                .setExpiration(exprTime)
                .compact();
    }

    public String validate(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECURITY_KEY).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
