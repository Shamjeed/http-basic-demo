package com.stc.httpbasicdemo.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
   @Override
   public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
      PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
      final User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);
      UserDetails user;
      if (s.equals("admin")) {
         user = userBuilder
                 .username("admin")
                 .password("password1")
                 .roles("user", "admin")
                 .build();
      } else {
         user = userBuilder
                 .username("user")
                 .password("password")
                 .roles("user")
                 .build();
      }
      return user;
   }
}
