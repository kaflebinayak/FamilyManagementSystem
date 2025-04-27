package com.binayak.family_management_system.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service

public class JWTService {

    private final String secretKey;
    private final String secreteKey = "32fb8b8a0751227cfed497cdf199ccd7b69f77cd515c1294aba1b14477129916ffd1b2ef04999fda52e16f690504780258411de864c2f63f51b051b74306e59c2cdfda8eae54eb8286781be3ec9fa0b49472e9d887bacaa914e7f7fa76af5a08e658d3437e1e48ffadbf7b55f5eeef5a2a85e051c3181565f218907b13f24ded6d5ed6666bc0f47b981e31f8e4f567538469511260ad306b6a00ba83a046e244a97ca07c78fb42686405f1547caecd8ff7af23ad5a1f3af034032be531b46d20683d124bdbe449db1fe7b88a16c6cbc57a4be7bc5b6f68b0a4c1cbd482f6ce856613a0f27d1a45bfefad763ef12a417ecb43d73b5990dba1ca963fd4a49e44eb" ;

    public JWTService(){
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk = keyGen.generateKey();
            secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String generateToken(String username) {

        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 10))
                .and()
                .signWith(getKey())
                .compact();


    }
    private Key getKey(){
        byte [] keyBytes = Decoders.BASE64.decode(secreteKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
