package com.jongmokim.personalnas.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class testController {
    
    @GetMapping("/greeting")
    public ResponseEntity<String> gretting() {
        return ResponseEntity.ok().body("greetings!");
    }

}
