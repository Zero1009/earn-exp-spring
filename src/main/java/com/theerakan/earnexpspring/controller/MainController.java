package com.theerakan.earnexpspring.controller;

import com.theerakan.earnexpspring.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController()
@RequestMapping("/main")
public class MainController {

    @Autowired
    FileService fileService;
    @GetMapping("")
    public ResponseEntity<String> helloworld() throws IOException {
        fileService.testFile();
        return ResponseEntity.status(200).body("Hello World!");

    }
}
