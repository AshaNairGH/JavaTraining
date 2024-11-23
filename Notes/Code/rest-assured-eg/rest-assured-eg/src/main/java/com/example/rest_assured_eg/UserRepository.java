package com.example.rest_assured_eg;

import com.example.rest_assured_eg.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

