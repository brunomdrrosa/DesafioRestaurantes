package com.dbserver.restaurantes.dto;

import java.time.LocalDateTime;

public class VoteDTO {
	private Long restaurantId;
	private String email;
	private Double vote = 1.0;
	private LocalDateTime date = LocalDateTime.now();
	
	public VoteDTO() {}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getVote() {
		return vote;
	}

	public void setVote(Double vote) {
		this.vote = vote;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}	
	
}
