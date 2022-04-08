package com.bodrudduja.sus.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bodrudduja.sus.dto.RankedUserProgressDTO;
import com.bodrudduja.sus.dto.UserProgressDTO;
import com.bodrudduja.sus.entity.UserProgress;

public interface UserProgressService {

	public ResponseEntity<UserProgress> getUserById(BigInteger userId);

	public ResponseEntity<List<RankedUserProgressDTO>> getRankedUserProgresses();

	public ResponseEntity<UserProgress> createUser(BigInteger userId, UserProgressDTO userProgressDTO);

	public ResponseEntity<UserProgress> updateUserById(BigInteger userId, UserProgressDTO userProgressDTO);
}
