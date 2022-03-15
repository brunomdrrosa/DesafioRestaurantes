package com.dbserver.restaurantes.services;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbserver.restaurantes.entities.Restaurant;
import com.dbserver.restaurantes.entities.User;
import com.dbserver.restaurantes.entities.Vote;
import com.dbserver.restaurantes.repositories.RestaurantRepository;
import com.dbserver.restaurantes.repositories.UserRepository;
import com.dbserver.restaurantes.repositories.VoteRepository;

@Service
public class VoteServices {

	@Autowired
	private VoteRepository repository;
	private UserRepository userRepository;
	private RestaurantRepository restaurantRepository;

	@Transactional
	public Vote vote(Long userId, Long restaurantId) {
		LocalDateTime votingLocalDateTime = LocalDateTime.now();
		final Restaurant restaurant = restaurantRepository.getById(restaurantId);
		final User user = userRepository.getById(userId);

		Vote vote;
		return repository.saveAndFlush(new Vote(null, votingLocalDateTime.toLocalDate(), user, restaurant));
	}
}
