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

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {

	@Autowired
	private RestaurantServices service;

	@GetMapping
	public Page<RestaurantDTO> findAll(Pageable pageable) {
		return service.findAll(pageable);
	}

	@GetMapping(value = "/{id}")
	public RestaurantDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@GetMapping(value = "/winner")
    public Restaurant findWinner(Integer count) {
        return service.findWinner(count);     
    };

	@PostMapping
	public Restaurant addRestaurant(@RequestBody Restaurant newRestaurant) {
		return service.addRestaurant(newRestaurant);
	}
	
}
