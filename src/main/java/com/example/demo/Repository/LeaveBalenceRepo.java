package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.response.LeaveBalence;

@Repository
public interface LeaveBalenceRepo extends JpaRepository<LeaveBalence, Integer> {

	
}
