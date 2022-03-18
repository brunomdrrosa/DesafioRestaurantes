package com.dbserver.restaurantes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbserver.restaurantes.dto.RestaurantDTO;
import com.dbserver.restaurantes.entities.Restaurant;
import com.dbserver.restaurantes.exceptions.NotFoundException;
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
	public Restaurant findWinner() throws NotFoundException {
		Optional<Restaurant> data = repository.findFirstByCountGreaterThanEqualOrderByCountDesc(3);
		if (data.isPresent()) {
			return data.get();
		}

		throw new NotFoundException(
				"Nenhum restaurante ganhou a votação, é necessário um total de 3 votos para ter um restaurante vencedor.");
	}

	@Transactional
	public Restaurant addRestaurant(Restaurant newRestaurant) {
		newRestaurant.setCount(0);
		return repository.saveAndFlush(newRestaurant);
	}

}
