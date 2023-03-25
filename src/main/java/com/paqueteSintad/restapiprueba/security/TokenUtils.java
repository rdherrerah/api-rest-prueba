package com.paquetesintad.restapiprueba.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {
  private static final String ACCESS_TOKEN_SECRET = "Um9ubnkgaG9sYSBxdWUgdGFsIGVzdGFtb3MgcHJvYmFuZG8";
  private static final Long ACCESS_TOKEN_VALIDITY_SECOND = 3600L;

  public static String createToken(String user, String pswd){
    long expirationTime = ACCESS_TOKEN_VALIDITY_SECOND*1000;
    Date expirationDate = new Date(System.currentTimeMillis()+expirationTime);

    Map<String,Object> extra = new HashMap<>();
    extra.put("user",user);

    return Jwts.builder()
      .setSubject(pswd)
      .setExpiration(expirationDate)
      .addClaims(extra)
      .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
      .compact();
  }

  public static UsernamePasswordAuthenticationToken getAuthentication(String token){
    try{
      Claims claims = Jwts.parserBuilder()
        .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
        .build()
        .parseClaimsJws(token)
        .getBody();
      String user = claims.getSubject();
      return new UsernamePasswordAuthenticationToken(user,null, Collections.emptyList());
    }catch (JwtException e){
      return null;
    }
  }
}
