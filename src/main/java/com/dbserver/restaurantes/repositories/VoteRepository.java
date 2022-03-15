package com.dbserver.restaurantes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbserver.restaurantes.entities.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
