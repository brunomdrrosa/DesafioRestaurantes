package com.dbserver.restaurantes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbserver.restaurantes.entities.Vote;
import com.dbserver.restaurantes.entities.VotePK;

public interface VoteRepository extends JpaRepository<Vote, VotePK> {
}
