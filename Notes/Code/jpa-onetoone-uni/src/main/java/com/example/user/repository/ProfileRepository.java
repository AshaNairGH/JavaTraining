package com.example.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile,Long>{

}
