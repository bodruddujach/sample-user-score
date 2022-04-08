package com.bodrudduja.sus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bodrudduja.sus.dto.RankedUserProgressDTO;
import com.bodrudduja.sus.service.UserProgressService;

@RestController
public class LeaderBoardController {

	@Autowired
	UserProgressService userProgressService;

	@GetMapping("/leader-board")
	public ResponseEntity<List<RankedUserProgressDTO>> getRankedUserProgresses() {
		return userProgressService.getRankedUserProgresses();
	}	
}
