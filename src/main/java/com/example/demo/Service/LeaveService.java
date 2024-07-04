package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.LeaveRepo;
import com.example.demo.model.response.LeaveRequest;

@Service
public class LeaveService {
	
	@Autowired
	private LeaveRepo leaveRepo;

	public LeaveRequest addLeave(LeaveRequest leave) {
		
		return leaveRepo.save(leave);
	}
	
	public List<LeaveRequest> getAllLeaveRequest(){
		return leaveRepo.findAll();
	}
	
	public Optional<LeaveRequest> getById(int id) {
		return leaveRepo.findById(id);
	}
	
}
