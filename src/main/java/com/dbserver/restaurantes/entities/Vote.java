package com.dbserver.restaurantes.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "db_vote")
public class Vote {
	
	@EmbeddedId
	private VotePK id = new VotePK();
	private Double value;
	
	public Vote() {}
	
	public void setRestaurant(Restaurant restaurant) {
		id.setRestaurant(restaurant);
	}
	
	public void setUser(User user) {
		id.setUser(user);
	}

	public VotePK getId() {
		return id;
	}

	public void setId(VotePK id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	
}