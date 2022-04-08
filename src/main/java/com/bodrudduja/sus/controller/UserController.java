package com.bodrudduja.sus.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bodrudduja.sus.entity.User;
import com.bodrudduja.sus.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") BigInteger id) {
		return userService.getUserById(id);
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable("id") BigInteger id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}
}
