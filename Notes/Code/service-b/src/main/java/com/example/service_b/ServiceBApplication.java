package com.example.service_b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ServiceBApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceBApplication.class, args);
	}

}

//http://localhost:8081/api/hello

@RestController
class ServiceAController{
	@GetMapping("/api/hello")
	public String hello() {
		return "Hello from Service B";
	}
}
