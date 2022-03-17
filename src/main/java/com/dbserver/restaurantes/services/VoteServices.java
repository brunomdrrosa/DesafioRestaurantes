package com.dbserver.restaurantes.services;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbserver.restaurantes.dto.RestaurantDTO;
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
		LocalDateTime date;
//		int dayMonth = date.getDayOfMonth();

		User user = userRepository.findByEmail(dto.getEmail());

		if (user == null) {
			throw new ResourceNotFoundException("O e-mail informado não foi encontrado no sistema");
		}
//		} else if () {
//			throw new AuthenticationException("Você já votou no dia de hoje, espere até amanhã para votar novamente!");
//		}

		Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId()).get();

		Vote vote = new Vote();
		vote.setRestaurant(restaurant);
		vote.setUser(user);
		vote.setValue(dto.getVote());

		vote = voteRepository.saveAndFlush(vote);

		double sum = 0;
		for (Vote v : restaurant.getVotes()) {
			sum = sum + v.getValue();
		}

		restaurant.setCount(restaurant.getVotes().size());

		restaurant = restaurantRepository.save(restaurant);

		return new RestaurantDTO(restaurant);
	}
	
}
