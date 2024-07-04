package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.LeaveTypeRepo;
import com.example.demo.model.response.LeaveTypes;

@Service
public class LeaveTypeService {

	@Autowired
	private LeaveTypeRepo leaveTypeRepo;
	
	public LeaveTypes addLeaveType(LeaveTypes leaveTypes) {
		return leaveTypeRepo.save(leaveTypes);
	}
	
	public List<LeaveTypes> getAllLeaveType(){
		return leaveTypeRepo.findAll();
	}
	
	public Optional<LeaveTypes> getLeaveTypeById(int id) {
		return leaveTypeRepo.findById(id);
	}
}
