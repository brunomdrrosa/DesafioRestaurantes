package com.dbserver.restaurantes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbserver.restaurantes.entities.User;
import com.dbserver.restaurantes.repositories.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository repository;
	
	@SuppressWarnings("rawtypes")
	@Transactional(readOnly = true)
	public List<User> findAllUsers(List list) {
		List<User> result = repository.findAll();
		return result;
	}
	
	@Transactional
	public User addUser(User newUser) {
		return repository.saveAndFlush(newUser);
	}
}
