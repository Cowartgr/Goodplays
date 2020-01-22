package com.goodplays.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goodplays.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
	User findByUsername(String userName);
	
	List<User> findAll();
}
