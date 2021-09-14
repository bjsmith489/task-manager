package com.example.todolist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.todolist.entities.User;
import com.example.todolist.exceptions.UserExistsException;
import com.example.todolist.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	public User addUser(String username, String password, String email) throws UserExistsException {
		
		if(!userRepository.existsByUsername(username)) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(passwordEncoder.encode(password));
			user.setEmail(email);
			userRepository.save(user);
			return user;
		}
		throw new UserExistsException("User already exists");
	}
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
