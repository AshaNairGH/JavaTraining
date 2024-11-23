package com.example.user.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.controller.UserController;
import com.example.user.model.Profile;
import com.example.user.model.User;
import com.example.user.repository.ProfileRepository;
import com.example.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
private UserRepository uRepo;
	
	@Autowired
private ProfileRepository pRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
public User	createUser(User user){
	//Profile prof = user.getProfile();
	//prof.setUser(user);
	logger.info("createUser - set user back to profile");
	return uRepo.save(user);
	}

public User getUser(long userid) {
	User user = null;
	Optional<User> ouser = uRepo.findById(userid);
	if (ouser.isPresent()) {
		user = ouser.get();
	}
	else {
		logger.warn("getUser - user is null!");
	}
	return user;
}

public Profile getProfile(long profid) {
	Profile profile = pRepo.findById(profid).get();
	return profile;
}

}
