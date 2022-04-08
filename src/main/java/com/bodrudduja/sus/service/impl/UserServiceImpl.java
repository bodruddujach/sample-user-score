package com.bodrudduja.sus.service.impl;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bodrudduja.sus.entity.User;
import com.bodrudduja.sus.repository.UserRepository;
import com.bodrudduja.sus.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public ResponseEntity<User> getUserById(BigInteger id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<User> createUser(User user) {
		try {
			User _user = userRepository.save(new User(user.getName(), user.getCountry()));
			return new ResponseEntity<>(_user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<User> updateUser(BigInteger id, User user) {
		Optional<User> userData = userRepository.findById(id);
		if (userData.isPresent()) {
			User _user = userData.get();
			_user.setName(user.getName());
			_user.setCountry(user.getCountry());
			return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
