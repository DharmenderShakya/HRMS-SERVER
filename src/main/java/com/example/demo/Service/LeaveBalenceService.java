package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.LeaveBalenceRepo;
import com.example.demo.model.response.Employee;
import com.example.demo.model.response.LeaveBalence;

@Service
public class LeaveBalenceService {

	@Autowired
	private LeaveBalenceRepo leaveBalenceRepo;
	
	@Autowired
	private EmloyeeService empEmloyeeService;
	
	public LeaveBalence addLeaveBalence(LeaveBalence leaveBalence) {
		Employee employee=empEmloyeeService.getEmployeeByName(leaveBalence.getName());
		LeaveBalence leaveBalence2=new LeaveBalence();
		leaveBalence2.setAccepted(leaveBalence.getAccepted());
		leaveBalence2.setName(employee.getName());
		leaveBalence2.setCarry(leaveBalence.getCarry());
		leaveBalence2.setCurrent(leaveBalence.getCurrent());
		leaveBalence2.setExpired(leaveBalence.getExpired());
		leaveBalence2.setPrevious(leaveBalence.getPrevious());
		leaveBalence2.setRejected(leaveBalence.getRejected());
		leaveBalence2.setTotal(leaveBalence.getTotal());
		leaveBalence2.setUsed(leaveBalence.getUsed());
		employee.setBalence(leaveBalence2);
		leaveBalence2.setEmployee(employee);
		return leaveBalenceRepo.save(leaveBalence2);
	}
	
	public List<LeaveBalence> getAllLeavecBalence(){
	
		return leaveBalenceRepo.findAll();
	}
	
	public Optional<LeaveBalence> getLeaveBalenceById(int id) {
		return leaveBalenceRepo.findById(id);
	}
}
