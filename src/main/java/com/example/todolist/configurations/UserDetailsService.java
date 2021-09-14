package com.example.todolist.configurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.todolist.entities.User;
import com.example.todolist.repositories.UserRepository;
@Service
public class UserDetailsService
		implements org.springframework.security.core.userdetails.UserDetailsService {
	@Autowired
	UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User 404");
		}
		
		return new UserDetailsImpl(user);
	}
	
	
}
