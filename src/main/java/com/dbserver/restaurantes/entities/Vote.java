package com.dbserver.restaurantes.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="db_votes")
public class Vote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference(value = "userVotes")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference(value = "restaurantVotes")
	private Restaurant restaurant;
	
	private LocalDate votingDate;
	
	public Vote(Object object, LocalDate localDate, User user2, Restaurant restaurant2) {
		// TODO Auto-generated constructor stub
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
	
	@Override
    public String toString() {
        return "Vote{" +
                ", id=" + id +
                "user=" + user +
                ", restaurant=" + restaurant +
                ", votingDate=" + votingDate +
                '}';
    }	
}
