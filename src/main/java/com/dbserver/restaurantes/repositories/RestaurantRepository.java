package com.dbserver.restaurantes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbserver.restaurantes.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	Optional<Restaurant> findFirstByCountGreaterThanEqualOrderByCountDesc (Integer count);
}
