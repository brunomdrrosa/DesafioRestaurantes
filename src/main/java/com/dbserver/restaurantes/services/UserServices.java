package com.dbserver.restaurantes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbserver.restaurantes.entities.User;
import com.dbserver.restaurantes.exceptions.HttpClientErrorException;
import com.dbserver.restaurantes.repositories.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository repository;

	PasswordEncoder passwordEncoder;

	public UserServices(UserRepository userRepository) {
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	@SuppressWarnings("rawtypes")
	@Transactional(readOnly = true)
	public List<User> findAllUsers(List list) {
		List<User> result = repository.findAll();
		return result;
	}

	@Transactional
	public User addUser(User newUser) {
		if (repository.findByEmail(newUser.getEmail()) != null) {
			throw new HttpClientErrorException("O e-mail informado já existe no sistema");
		}
		String encodedPassword = this.passwordEncoder.encode(newUser.getPassword());
		newUser.setPassword(encodedPassword);
		return repository.saveAndFlush(newUser);
	}
	
	@Scheduled(cron = "0 00 18 * * *")
	  public void resetVotes() throws InterruptedException {
	    
		List<User> userArray = repository.findAll();
		for(User user: userArray ) {
			user.setVoted(false);
		}
		
		repository.saveAllAndFlush(userArray);
	  }

}
