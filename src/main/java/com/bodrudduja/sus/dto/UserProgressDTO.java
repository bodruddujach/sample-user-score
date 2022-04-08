package com.bodrudduja.sus.dto;

public class UserProgressDTO {

	int level;
	float score;

	public UserProgressDTO() {
	}

	public UserProgressDTO(int level, float score) {
		this.level = level;
		this.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

}