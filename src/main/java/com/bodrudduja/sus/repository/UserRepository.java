package com.bodrudduja.sus.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bodrudduja.sus.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, BigInteger> {

}
