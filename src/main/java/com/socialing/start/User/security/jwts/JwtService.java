package com.socialing.start.User.security.jwts;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

   private final String SECRET_KEY = "ABJABAD^*^**@#NKANDPASD)NADKADNJKADN/*5555aASDASD$#@!";

   public String generateToken(String username){

       return Jwts.builder()
               .setSubject(username)
               .setIssuedAt(new Date())
               .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60)) //1 hour
               .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
               .compact();
   }


   public String extractUsername(String token){

       return Jwts.parserBuilder()
               .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
               .build()
               .parseClaimsJws(token)
               .getBody()
               .getSubject();
   }


}
