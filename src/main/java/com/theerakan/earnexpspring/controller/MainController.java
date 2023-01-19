package com.theerakan.earnexpspring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/main")
public class MainController {

    @GetMapping("")
    public ResponseEntity<String> helloworld(){
        return ResponseEntity.status(200).body("Hello World!");
    }
}
