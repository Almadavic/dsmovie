package com.devsuperior.dsmovie.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmovie.dto.UserDTO;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public UserDTO findByEmail(String email) {
		Optional<User> user = repository.findByEmail(email);
		if(user.isEmpty()) {
			User newUser = new User();
			newUser.setEmail(email);
			repository.save(newUser);
			return null;
		}
		return new UserDTO(user.get());
	}

}
