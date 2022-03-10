package com.devsuperior.dsmovie.dto;

import com.devsuperior.dsmovie.entities.User;

public class UserDTO {

	private Long id;
	private String email;

	public UserDTO(User user) {
		id = user.getId();
		email = user.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User toUser() {
		User user = new User();
		user.setEmail(email);
		user.setId(id);
		return user;
	}

}
