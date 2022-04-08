package com.bodrudduja.sus.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.ConstructorResult;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bodrudduja.sus.dto.RankedUserProgressDTO;

@Entity
@Table(name="user_progress")
@NamedNativeQuery(
	    name = "find_ranked_user_progress_dto",
	    query =
	        "SELECT " + 
	        "  RANK() OVER (ORDER BY score DESC) 'rank', up.level, u.name, up.score " + 
	        "FROM user_progress up JOIN user u ON up.user_id=u.id " + 
	        "ORDER BY up.score DESC " + 
	        "LIMIT 10",
	    resultSetMapping = "ranked_user_progress_dto"
	)
	@SqlResultSetMapping(
	    name = "ranked_user_progress_dto",
	    classes = @ConstructorResult(
	        targetClass = RankedUserProgressDTO.class,
	        columns = {
	            @ColumnResult(name = "rank", type = BigInteger.class),
	            @ColumnResult(name = "level", type = Integer.class),
	            @ColumnResult(name = "name", type = String.class),
	            @ColumnResult(name = "score", type = Float.class)
	        }
	    )
	)
public class UserProgress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "BIGINT")
	private BigInteger id;

	@Column
	int level;
	
	@Column
	float score;

	@OneToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

	public UserProgress() {
	}

	public UserProgress(BigInteger id, int level, float score, User user) {
		this.id = id;
		this.level = level;
		this.score = score;
		this.user = user;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
