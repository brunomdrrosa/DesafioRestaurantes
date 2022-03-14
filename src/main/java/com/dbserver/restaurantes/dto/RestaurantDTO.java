package com.dbserver.restaurantes.dto;

import com.dbserver.restaurantes.entities.Restaurant;

public class RestaurantDTO {
	private Long id;
	private String nome;
	private String address;
	private String website;
	private String description;

	public RestaurantDTO() {
	}

	public RestaurantDTO(Long id, String nome, String address, String website, String description) {
		this.id = id;
		this.nome = nome;
		this.address = address;
		this.website = website;
		this.description = description;
	}

	public RestaurantDTO(Restaurant restaurant) {
		id = restaurant.getId();
		nome = restaurant.getName();
		address = restaurant.getAddress();
		website = restaurant.getWebsite();
		description = restaurant.getDescription();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
