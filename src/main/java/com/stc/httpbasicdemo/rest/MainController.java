package com.stc.httpbasicdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

   @GetMapping("user")
   public ResponseEntity<?> userSection(){
      return new ResponseEntity<>("Welcome to user section!", HttpStatus.OK);
   }

   @GetMapping("admin")
   public ResponseEntity<?> adminSection(){
      return new ResponseEntity<>("Welcome to admin section!", HttpStatus.OK);
   }

}
