package com.apollo.clinicManagementSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ServiceController {

    @GetMapping
    public ResponseEntity<String> serverStatus(){
        return new ResponseEntity<>("Server is live", HttpStatus.OK);
    }
}
