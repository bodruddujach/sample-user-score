package com.bodrudduja.sus.dto;

import java.math.BigInteger;

public class RankedUserProgressDTO {

	private BigInteger rank;
	private Integer level;
	private String name;
	private Float score;

	public RankedUserProgressDTO() {
	}

	public RankedUserProgressDTO(BigInteger rank, Integer level, String name, Float score) {
		this.rank = rank;
		this.level = level;
		this.name = name;
		this.score = score;
	}

	public BigInteger getRank() {
		return rank;
	}

	public void setRank(BigInteger rank) {
		this.rank = rank;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

}
