package com.dbserver.restaurantes.dto;

public class VoteDTO {
	private Long restaurantId;
	private String email;
	private Double vote;
	
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
	
	
}
