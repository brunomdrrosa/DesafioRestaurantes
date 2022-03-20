package com.dbserver.restaurantes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbserver.restaurantes.entities.User;
import com.dbserver.restaurantes.services.UserServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/users")
@Tag(name = "users", description="Create your registration to vote for a restaurant")
public class UserController {

	@Autowired
	private UserServices service;

	@PostMapping
	@Operation(summary = "Create a user", description = "Create a user in the system, if there is already a user with the given email, a 409 error is returned.")
	public User addUser(@RequestBody User newUser) {
		return service.addUser(newUser);
	}

}
