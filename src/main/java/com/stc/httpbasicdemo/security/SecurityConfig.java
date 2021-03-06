package com.stc.httpbasicdemo.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.csrf().disable()
              .authorizeRequests()
              .antMatchers("/user").hasRole("user")
              .antMatchers("/admin").hasRole("admin")
              .and().httpBasic();
   }
}
