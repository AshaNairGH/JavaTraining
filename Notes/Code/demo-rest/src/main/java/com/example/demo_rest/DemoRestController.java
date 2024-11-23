package com.example.demo_rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tkt")
public class DemoRestController {

	@GetMapping("/hello")
	String met() {
		return "Hello World";
	}
	
	@GetMapping("/person")
	User getUser(){
		return new User(1,"some user","some addr");
	}
}
