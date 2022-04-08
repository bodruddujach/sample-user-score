package com.bodrudduja.sus.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.bodrudduja.sus.entity.User;

public interface UserService {

	public ResponseEntity<User> getUserById(BigInteger id);
	
	public ResponseEntity<User> createUser(User user);
	
	public ResponseEntity<User> updateUser(BigInteger id, User user);
}
