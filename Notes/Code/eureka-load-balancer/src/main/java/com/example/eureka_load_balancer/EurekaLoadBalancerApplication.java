package com.example.eureka_load_balancer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaLoadBalancerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaLoadBalancerApplication.class, args);
	}

}
