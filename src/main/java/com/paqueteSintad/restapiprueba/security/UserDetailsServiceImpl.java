package com.paquetesintad.restapiprueba.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Value("${user.credential}")
  private String userCredential;
  @Value("${pswd.credentials}")
  private String pswdCredentials;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Map<String,String > usuario = new HashMap<>();
    usuario.put("user",this.userCredential);
    usuario.put("pswd",this.pswdCredentials);
    return new UserDetailsImpl(usuario);
  }
}
