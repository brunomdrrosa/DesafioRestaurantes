package com.dbserver.restaurantes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbserver.restaurantes.dto.RestaurantDTO;
import com.dbserver.restaurantes.dto.VoteDTO;
import com.dbserver.restaurantes.services.VoteServices;

@RestController
@RequestMapping(value = "/votes")
public class VoteController {

	@Autowired
	private VoteServices service;
	
	@PostMapping
	public RestaurantDTO saveVote(@RequestBody VoteDTO dto) {
		RestaurantDTO restaurantDTO = service.saveVote(dto);
		return restaurantDTO;
	}
	
}
