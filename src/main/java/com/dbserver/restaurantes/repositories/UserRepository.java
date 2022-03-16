package com.dbserver.restaurantes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbserver.restaurantes.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
