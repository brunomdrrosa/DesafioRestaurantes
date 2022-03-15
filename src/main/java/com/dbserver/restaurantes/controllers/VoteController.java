package com.dbserver.restaurantes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbserver.restaurantes.entities.User;
import com.dbserver.restaurantes.entities.Vote;
import com.dbserver.restaurantes.services.VoteServices;

@RestController
@RequestMapping(value = "/votes")
public class VoteController {

	@Autowired
	private VoteServices service;
	
	@PostMapping
	public Vote vote(@RequestBody User user, Long restaurantId) {
		Vote created = service.vote(user.getId(), restaurantId);
		return created;
	}
}
