package com.tiantianchat.config;

import com.tiantianchat.heartstone.model.entity.PlayerEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *
 */
@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.sessionTime}")
    private int sessionTime;

    public String toToken(PlayerEntity user) {
        return Jwts.builder()
                .setSubject(String.valueOf(user.getId()))
                .setExpiration(expireTimeFromNow())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getSubFromToken(String token) {
        return Jwts.parser().
                setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    private Date expireTimeFromNow() {
        return new Date(System.currentTimeMillis() + sessionTime * 1000);
    }
}
