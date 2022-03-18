package com.dbserver.restaurantes.dto;

import com.dbserver.restaurantes.entities.User;

public class UserDTO {
	private Long id;
	private String username;
	private String email;
	private String password;
	private Boolean voted = false;

	public UserDTO() {
	}

	public UserDTO(Long id, String username, String email, String password, Boolean voted) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.voted = voted;
	}

	public UserDTO(User user) {
		id = user.getId();
		username = user.getUsername();
		email = user.getEmail();
		password = user.getPassword();
		voted = user.getVoted();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getVoted() {
		return voted;
	}

	public void setVoted(Boolean voted) {
		this.voted = voted;
	}

	
}
