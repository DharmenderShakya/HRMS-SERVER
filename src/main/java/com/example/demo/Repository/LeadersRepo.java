package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.response.Leaders;

@Repository
public interface LeadersRepo extends JpaRepository<Leaders, Integer> {

	public Leaders findLeadersByName(String name);
}
