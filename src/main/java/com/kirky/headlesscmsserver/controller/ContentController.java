package com.kirky.headlesscmsserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/content")
public class ContentController {
    @GetMapping
    public ResponseEntity<String> getContent() {
        return new ResponseEntity<>("Content", HttpStatus.OK);
    }
}
