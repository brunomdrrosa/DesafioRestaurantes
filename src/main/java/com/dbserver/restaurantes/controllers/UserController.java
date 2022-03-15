package com.dbserver.restaurantes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbserver.restaurantes.entities.User;
import com.dbserver.restaurantes.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserServices service;

	@PostMapping
	public User addUser(@RequestBody User newUser) {
		return service.addUser(newUser);
	}
}
