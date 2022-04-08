package com.bodrudduja.sus.service.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bodrudduja.sus.dto.RankedUserProgressDTO;
import com.bodrudduja.sus.dto.UserProgressDTO;
import com.bodrudduja.sus.entity.User;
import com.bodrudduja.sus.entity.UserProgress;
import com.bodrudduja.sus.repository.UserProgressRepository;
import com.bodrudduja.sus.repository.UserRepository;
import com.bodrudduja.sus.service.UserProgressService;

@Service
public class UserProgressServiceImpl implements UserProgressService {

	@Autowired
	UserProgressRepository userProgressRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public ResponseEntity<UserProgress> getUserById(BigInteger userId) {
		Optional<UserProgress> userProgress = userProgressRepository.findByUser_id(userId);
		if (userProgress.isPresent()) {
			UserProgress u = userProgress.get();
			return new ResponseEntity<>(u, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<List<RankedUserProgressDTO>> getRankedUserProgresses() {
		List<RankedUserProgressDTO> rankedUserProgresses = userProgressRepository.findLeaderBoard();
		if (rankedUserProgresses != null && !rankedUserProgresses.isEmpty()) {
			return new ResponseEntity<>(rankedUserProgresses, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<UserProgress> createUser(BigInteger userId, UserProgressDTO userProgressDTO) {
		try {
			Optional<User> user = Optional
					.of(userRepository.findById(userId).orElseThrow(() -> new Exception("userId not found" + userId)));
			UserProgress userProgress = new UserProgress();
			userProgress.setLevel(userProgressDTO.getLevel());
			userProgress.setScore(userProgressDTO.getScore());
			userProgress.setUser(user.get());
			UserProgress _userProgress = userProgressRepository.save(userProgress);
			return new ResponseEntity<>(_userProgress, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<UserProgress> updateUserById(BigInteger userId, UserProgressDTO userProgressDTO) {
		Optional<UserProgress> userProgressData = userProgressRepository.findByUser_id(userId);
		if (userProgressData.isPresent()) {
			UserProgress _userProgress = userProgressData.get();
			_userProgress.setLevel(userProgressDTO.getLevel());
			_userProgress.setScore(userProgressDTO.getScore());
			return new ResponseEntity<>(userProgressRepository.save(_userProgress), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
