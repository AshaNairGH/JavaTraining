package com.example.eg.cloud.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/service-a/**")
                        .uri("http://localhost:8081/"))

                .route(r -> r.path("/service-b/**")
                        .uri("http://localhost:8082/"))
                .build();
    }

}