package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.response.User;

@Repository
public interface UserRepository extends JpaRepository<com.example.demo.model.response.User, Integer> {

	public User findByUserName(String user);
	
	public User findByFirstName(String name);
}
