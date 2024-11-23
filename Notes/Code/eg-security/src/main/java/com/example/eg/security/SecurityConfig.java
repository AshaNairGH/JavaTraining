package com.example.eg.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Configure in-memory authentication
    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = 
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
            .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("secret")).roles("ADMIN");

        return authenticationManagerBuilder.build();
    }

    // Security filter chain as shown earlier
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {        
        http.csrf().disable()
        .authorizeHttpRequests((authorize)->{
            authorize.requestMatchers("/admin/**","/someurl/**").authenticated();

            authorize.anyRequest().permitAll();
        }).httpBasic(Customizer.withDefaults());
return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Password encoder for user credentials
    }
}