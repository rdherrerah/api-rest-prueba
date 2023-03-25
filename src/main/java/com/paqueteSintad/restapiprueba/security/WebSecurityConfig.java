package com.paquetesintad.restapiprueba.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

  private final UserDetailsService userDetailsService;
  private final JwtAuthorizationFilter jwtAuthorizationFilter;

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception{
    JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter();
    jwtAuthenticationFilter.setAuthenticationManager(authManager);
    jwtAuthenticationFilter.setFilterProcessesUrl("/jwt");

    return http
      .csrf().disable()
      .authorizeRequests()
      .anyRequest()
      .authenticated()
      .and()
//      .httpBasic()
//      .and()
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      .addFilter(jwtAuthenticationFilter)
      .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
      .build();
  }

//  @Bean
//  UserDetailsService userDetailsService(){
//    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//    manager.createUser(User.withUsername("ADMIN")
//      .password(passwordEncoder().encode("admin"))
//      .roles()
//      .build());
//    return manager;
//  }

  @Bean
  PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Bean
  AuthenticationManager authenticationManager(HttpSecurity http,PasswordEncoder pswd) throws Exception{
    return http.getSharedObject(AuthenticationManagerBuilder.class)
      .userDetailsService(userDetailsService)
      .passwordEncoder(pswd)
      .and()
      .build();
  }
}
