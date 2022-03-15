package com.dbserver.restaurantes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbserver.restaurantes.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
}
