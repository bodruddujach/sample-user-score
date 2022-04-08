package com.bodrudduja.sus.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bodrudduja.sus.dto.RankedUserProgressDTO;
import com.bodrudduja.sus.entity.UserProgress;

@Repository
public interface UserProgressRepository extends JpaRepository<UserProgress, BigInteger> {

	Optional<UserProgress> findByUser_id(BigInteger userId);

	@Query(name = "find_ranked_user_progress_dto", nativeQuery = true)
	List<RankedUserProgressDTO> findLeaderBoard();
}
