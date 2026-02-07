//package com.catering.catering_hub.configs;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.security.SecureRandom;
//import java.util.Base64;
//import java.util.Date;
//
//@Component
//public class JwtUtil {
//    @Value("${jwt.secret:}")  // Default to an empty string if not set
//    private String secretKey;
//
//    @PostConstruct
//    public void init() {
//        if (secretKey.isEmpty()) {
//            // If no secret key is set in application.properties, generate one dynamically
//            byte[] key = new byte[64]; // Generate a 512-bit key
//            new SecureRandom().nextBytes(key);
//            secretKey = Base64.getEncoder().encodeToString(key);  // Encode it in Base64
//
//            System.out.println("Generated secret key: " + secretKey);  // Log it or save securely
//        }
//    }
//
//    public String generateToken(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
//                .signWith(SignatureAlgorithm.HS256, secretKey)
//                .compact();
//    }
//
//    public String extractUsername(String token) {
//        return Jwts.parser().setSigningKey(secretKey)
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//    }
//
//    public Boolean validateToken(String token, UserDetails userDetails) {
//        final String username = extractUsername(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
//
//    private Boolean isTokenExpired(String token) {
//        final Date expiration = Jwts.parser()
//                .setSigningKey(secretKey)
//                .parseClaimsJws(token)
//                .getBody()
//                .getExpiration();
//        return expiration.before(new Date());
//    }
//}
//
