package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.response.LeaveRequest;

@Repository
public interface LeaveRepo extends JpaRepository<LeaveRequest,Integer> {

	
}
