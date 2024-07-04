package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.LeaveRequestRepo;
import com.example.demo.Service.LeaveBalenceService;
import com.example.demo.Service.LeaveService;
import com.example.demo.Service.LeaveTypeService;
import com.example.demo.model.response.LeaveBalence;
import com.example.demo.model.response.LeaveRequest;
import com.example.demo.model.response.LeaveTypes;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RequestMapping("/hrms")
@RestController
@CrossOrigin("*")
public class LeaveController {

	@Autowired
	private LeaveTypeService leaveTypeService;
	
	@Autowired
	private LeaveService leaveRequestService;
	
	@Autowired
	private LeaveBalenceService leaveBalenceService;
	
	@Autowired
	private LeaveRequestRepo leavRepo;
	
	// Leave Types
	
	@PostMapping("/leaveType")
	public LeaveTypes postLeaveType(@RequestBody LeaveTypes entity) {
		
		return leaveTypeService.addLeaveType(entity);
	}
	@GetMapping("/getAllLeaveType")
	public List<LeaveTypes> getMethodName() {
		return leaveTypeService.getAllLeaveType();
	}
	
	@GetMapping("/getTypeById")
	public Optional<LeaveTypes> getMethodName(int id) {
		return leaveTypeService.getLeaveTypeById(id);
	}
	
	// Leave request
	
	@PostMapping("/leaveRequest")
	public LeaveRequest postLeaveRequest(@RequestBody LeaveRequest entity) {
		return leaveRequestService.addLeave(entity);
	}
	@GetMapping("/getAllLeaveRequest")
	public List<LeaveRequest> getAllLeaveRequest() {
		return leaveRequestService.getAllLeaveRequest();
	}
	@PutMapping("/updateRequest")
	public LeaveRequest updateRequest(@RequestBody LeaveRequest leaveRequest) {
		LeaveRequest leaveRequest2=leavRepo.findById(leaveRequest.getId()).get();
		leaveRequest2.setName(leaveRequest.getName());
		leaveRequest2.setReason(leaveRequest.getReason());
		leaveRequest2.setLeaveDays(leaveRequest.getLeaveDays());
		leaveRequest2.setFrom(leaveRequest.getFrom());
		leaveRequest2.setTo(leaveRequest.getTo());
		leaveRequest2.setLeaveType(leaveRequest.getLeaveType());
		leaveRequest2.setStatus(leaveRequest.getStatus());
		return leavRepo.save(leaveRequest2);
	}
	
	@GetMapping("/getLeaveRequestById")
	public Optional<LeaveRequest> getLeaveRequestById(int id) {
		return leaveRequestService.getById(id);
	}
	
	// Leave Balence
	
	@PostMapping("/leaveBalence")
	public LeaveBalence postLeaveBalence(@RequestBody LeaveBalence entity) {
		return leaveBalenceService.addLeaveBalence(entity);
	}
	@GetMapping("/getAllLeaveBalence")
	public List<LeaveBalence> getAllLeaveBalence() {
		return leaveBalenceService.getAllLeavecBalence();
	}
	
	@GetMapping("/getLeaveBalenceById")
	public Optional<LeaveBalence> getLeaveBalenceById(int id) {
		return leaveBalenceService.getLeaveBalenceById(id);
	}
	
}
