package com.dbserver.restaurantes.dto;

import java.time.LocalDate;

import com.dbserver.restaurantes.entities.Restaurant;
import com.dbserver.restaurantes.entities.User;
import com.dbserver.restaurantes.entities.Vote;

public class VoteDTO {
	private Long id;
	private User user;
	private Restaurant restaurant;
	private LocalDate votingDate;
	
	public VoteDTO() {}

	public VoteDTO(Long id, User user, Restaurant restaurant, LocalDate votingDate) {
		this.id = id;
		this.user = user;
		this.restaurant = restaurant;
		this.votingDate = votingDate;
	}
	
	public VoteDTO(Vote vote) {
		id = vote.getId();
		user = vote.getUser();
		restaurant = vote.getRestaurant();
		votingDate = vote.getVotingDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public LocalDate getVotingDate() {
		return votingDate;
	}

	public void setVotingDate(LocalDate votingDate) {
		this.votingDate = votingDate;
	}
		
}
