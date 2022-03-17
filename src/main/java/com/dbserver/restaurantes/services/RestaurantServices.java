package com.dbserver.restaurantes.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbserver.restaurantes.dto.RestaurantDTO;
import com.dbserver.restaurantes.entities.Restaurant;
import com.dbserver.restaurantes.repositories.RestaurantRepository;

@Service
public class RestaurantServices {

	@Autowired
	private RestaurantRepository repository;

	@Transactional(readOnly = true)
	public Page<RestaurantDTO> findAll(Pageable pageable) {
		Page<Restaurant> result = repository.findAll(pageable);
		Page<RestaurantDTO> page = result.map(x -> new RestaurantDTO(x));
		return page;
	}

	@Transactional(readOnly = true)
	public RestaurantDTO findById(Long id) {
		Restaurant result = repository.findById(id).get();
		RestaurantDTO dto = new RestaurantDTO(result);
		return dto;
	}

	@Transactional(readOnly = true)
	public Restaurant findWinner(Integer count) {
	    List<Restaurant> restaurants = repository.findAll();
	    
	    for (Restaurant restaurant: restaurants) {
	    	Hibernate.initialize(restaurant.getCount());
	        if(restaurant.getCount().equals(3)) {
	            return restaurant;
	        }
	    }
	    return null;
	}

	@Transactional
	public Restaurant addRestaurant(Restaurant newRestaurant) {
		return repository.saveAndFlush(newRestaurant);
	}

}
