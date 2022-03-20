package com.dbserver.restaurantes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbserver.restaurantes.dto.RestaurantDTO;
import com.dbserver.restaurantes.entities.Restaurant;
import com.dbserver.restaurantes.services.RestaurantServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/restaurants")
@Tag(name = "restaurants", description="Operations about restaurants")
public class RestaurantController {

	@Autowired
	private RestaurantServices service;

	@GetMapping
	@Operation(summary = "Get all the restaurants", description = "Get a list of all the restaurants registered in the system.")
	public Page<RestaurantDTO> findAll(@Parameter(hidden = true) Pageable pageable) {
		return service.findAll(pageable);
	}

	@Operation(summary = "Get a restaurant by ID", description = "Get a restaurant registered in the system by ID.")
	@GetMapping(value = "/{id}")
	public RestaurantDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@Operation(summary = "Get a restaurant that won the vote", description = "The winning restaurant will be the one with 3 votes, if there is more than one restaurant with 3 votes, the one with the most votes is chosen.")
	@GetMapping(value = "/winner")
	public Restaurant findWinner() {
		return service.findWinner();
	};

	@PostMapping
	@Operation(summary = "Create a restaurant", description = "Create a restaurant in the system.")
	public Restaurant addRestaurant(@RequestBody Restaurant newRestaurant) {
		return service.addRestaurant(newRestaurant);
	}

}
