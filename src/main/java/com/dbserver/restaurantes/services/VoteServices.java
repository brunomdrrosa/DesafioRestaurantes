package com.dbserver.restaurantes.services;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbserver.restaurantes.dto.RestaurantDTO;
import com.dbserver.restaurantes.dto.UserDTO;
import com.dbserver.restaurantes.dto.VoteDTO;
import com.dbserver.restaurantes.entities.Restaurant;
import com.dbserver.restaurantes.entities.User;
import com.dbserver.restaurantes.entities.Vote;
import com.dbserver.restaurantes.exceptions.AuthenticationException;
import com.dbserver.restaurantes.exceptions.ResourceNotFoundException;
import com.dbserver.restaurantes.repositories.RestaurantRepository;
import com.dbserver.restaurantes.repositories.UserRepository;
import com.dbserver.restaurantes.repositories.VoteRepository;

@Service
public class VoteServices {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VoteRepository voteRepository;

	@Transactional
	public RestaurantDTO saveVote(VoteDTO dto) {

		User user = userRepository.findByEmail(dto.getEmail());

		LocalDateTime date = LocalDateTime.now();
		int dayMonth = date.getDayOfMonth();

		if (user == null) {
			throw new ResourceNotFoundException("O e-mail informado não foi encontrado no sistema");
		}

		Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId()).get();

		Vote vote = new Vote();
		
	    vote.setDate(date);
		vote.setRestaurant(restaurant);
		vote.setUser(user);
		vote.setValue(dto.getVote());

		if (user.getVoted() == true) {
			throw new AuthenticationException("Você já votou no dia de hoje, espere até amanhã para votar novamente!");
		}

		user.setVoted(true);

		vote = voteRepository.saveAndFlush(vote);

		restaurant.setCount(restaurant.getVotes().size());

		restaurant = restaurantRepository.save(restaurant);

		return new RestaurantDTO(restaurant);
	}
	
	public RestaurantDTO resetVotes(VoteDTO dto) {
		User user = userRepository.findByEmail(dto.getEmail());
		user.setVoted(false);
		
		Restaurant restaurant = (Restaurant) restaurantRepository.findAll();
		restaurant.setCount(0);
		restaurant = restaurantRepository.save(restaurant);

		return new RestaurantDTO(restaurant);
	}
}
