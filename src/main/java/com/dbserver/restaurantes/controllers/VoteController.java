package com.dbserver.restaurantes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbserver.restaurantes.dto.RestaurantDTO;
import com.dbserver.restaurantes.dto.VoteDTO;
import com.dbserver.restaurantes.services.VoteServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/votes")
@Tag(name = "votes", description="Choose the restaurant you want to have lunch")
public class VoteController {

	@Autowired
	private VoteServices service;

	@PostMapping
	@Operation(summary = "Add a vote for a restaurant", description = "Add a vote for a restaurant in the system, if the user has already voted on the day, a 401 error is returned. It is also possible to receive a 404 error if the e-mail provided does not exist in the system.")
	public RestaurantDTO saveVote(@RequestBody VoteDTO dto) {
		RestaurantDTO restaurantDTO = service.saveVote(dto);
		return restaurantDTO;
	}

}
