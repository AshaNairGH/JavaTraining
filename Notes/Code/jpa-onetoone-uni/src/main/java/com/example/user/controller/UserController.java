	package com.example.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.model.Profile;
import com.example.user.model.User;
import com.example.user.service.UserService;

/* TRACE - detailed debugging 
 * DEBUG - detailed info for developers, 
 * INFO - info about flow of application 
 * WARN - possible harmful situations 
 * ERROR - errors during execution 
 * FATAL - may terminate application
 * */

@RestController
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	public UserController() {
		logger.info("UserController() constructor invoked!");
	}
	
	@Autowired
	private UserService uService;
	
	@PostMapping
	public User creatUser(@RequestBody User user) {
		logger.info("Post Request is hit!");
		logger.debug("RequestBody object:" + user);
		return uService.createUser(user);
}
	@GetMapping("/{userid}")
	public User getUser(@PathVariable long userid) {
		return uService.getUser(userid);
	}
	
	@GetMapping("/prof/{profid}")
	public Profile getProf(@PathVariable long profid) {
		return uService.getProfile(profid);
	}
}
