package com.example.service_a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ServiceAApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAApplication.class, args);
	}

}

//http://localhost:8081/api/hello

@RestController
class ServiceAController{
	@GetMapping("/api/hello")
	public String hello() {
		return "Hello from Service A";
	}
}
