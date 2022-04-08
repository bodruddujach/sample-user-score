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

import com.bodrudduja.sus.dto.UserProgressDTO;
import com.bodrudduja.sus.entity.UserProgress;
import com.bodrudduja.sus.service.UserProgressService;

@RestController
public class UserProgressController {

	@Autowired
	UserProgressService userProgressService;

	@GetMapping("/user-progresses/{user-id}")
	public ResponseEntity<UserProgress> getUserById(@PathVariable("user-id") BigInteger userId) {
		return userProgressService.getUserById(userId);
	}

	@PostMapping("/user-progresses/{user-id}")
	public ResponseEntity<UserProgress> createUser(@PathVariable("user-id") BigInteger userId,
			@RequestBody UserProgressDTO userProgressDTO) {
		return userProgressService.createUser(userId, userProgressDTO);
	}

	@PutMapping("/user-progresses/{user-id}")
	public ResponseEntity<UserProgress> updateUserById(@PathVariable("user-id") BigInteger userId,
			@RequestBody UserProgressDTO userProgressDTO) {
		return userProgressService.updateUserById(userId, userProgressDTO);
	}
}
