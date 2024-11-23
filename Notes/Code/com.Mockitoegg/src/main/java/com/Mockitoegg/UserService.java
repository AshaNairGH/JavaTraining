package com.Mockitoegg;

public class UserService {
private final UserRepository userRepository;

public UserService(UserRepository userRepository) {
	this.userRepository = userRepository;
}

public String getUserName(Long id) {
	User user = userRepository.findById(id);
	return user != null?user.getName():"Unknown";
}
}
