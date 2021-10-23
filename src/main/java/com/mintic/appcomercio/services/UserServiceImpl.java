package com.mintic.appcomercio.services;

import com.mintic.appcomercio.models.User;
import com.mintic.appcomercio.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public Iterable<User> getAllUsers() {
		return repository.findAll();
	}

}