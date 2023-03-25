package com.paquetesintad.restapiprueba.security;

import lombok.Data;

@Data
public class AuthCredentials {
  private String user;
  private String pswd;

}
