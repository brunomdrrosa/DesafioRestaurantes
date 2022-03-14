package com.dbserver.restaurantes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbserver.restaurantes.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
