package com.paquetesintad.restapiprueba.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
  @Override
  public Authentication attemptAuthentication(HttpServletRequest request,
                                              HttpServletResponse response) throws AuthenticationException {
    AuthCredentials authCredentials = new AuthCredentials();
    try {
      authCredentials = new ObjectMapper().readValue(request.getReader(),AuthCredentials.class);
    }catch (IOException e){

    }
    UsernamePasswordAuthenticationToken userNamePAT = new UsernamePasswordAuthenticationToken(
      authCredentials.getUser(),
      authCredentials.getPswd(),
      Collections.emptyList()
    );
    return getAuthenticationManager().authenticate(userNamePAT);
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request,
                                          HttpServletResponse response,
                                          FilterChain chain,
                                          Authentication authResult) throws IOException, ServletException {

    UserDetails userDetails = (UserDetails) authResult.getPrincipal();
    String token = TokenUtils.createToken(userDetails.getUsername(),userDetails.getPassword());

    response.addHeader("Authorization","Bearer "+token);
    response.setContentType("application/json; charset=UTF-8");
    response.getWriter().write("{\"accessToken\":\""+token+"\"}");
    response.getWriter().flush();
    super.successfulAuthentication(request, response, chain, authResult);
  }
}
