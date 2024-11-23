package com.example.eg.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Hello, Admin!";
    } 
    
    @GetMapping("/someurl")
    public String met() {
        return "This is some url";
    }
}
