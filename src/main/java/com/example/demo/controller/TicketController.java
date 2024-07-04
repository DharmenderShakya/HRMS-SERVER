package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Repository.TeamRepo;
import com.example.demo.Repository.TicketRepo;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.TeamService;
import com.example.demo.Service.UserService;
import com.example.demo.model.response.Team;
import com.example.demo.model.response.Ticket;
import com.example.demo.model.response.User;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/hrms")
@CrossOrigin("*")
public class TicketController {

	@Autowired
	private TicketRepo ticketRepo;
	
	@Autowired
	private TeamRepo teamRepo;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private UserService authenticationController;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TeamService teamService;
	
	
	@PostMapping("/addTicket")
	public Ticket addTicket(@RequestBody Ticket ticket) {
//		if(authenticationController.getCurrentUser()=="ADMIN") {
//			Team team=teamRepo.findById(ticket.getId()).get();
//			ticket.setTeam(team);
//		}
//		if(authenticationController.getCurrentUser().toUpperCase().contains("LEADER")) {
//			Employee employee=employeeRepository.findById(ticket.getId()).get();
//			ticket.setEmployee(employee);
//		}
//		if(authenticationController.getCurrentUser().toUpperCase().contains("CLIENT")) {
//			Employee employee=employeeRepository.findById(ticket.getId()).get();
//			ticket.setEmployee(employee);
//		}
		ticket.setDate(new Date());
		User user=userRepository.findByUserName(ticket.getCreatedBy());
		ticket.setCreatedBy(user.getFirstName());
		return ticketRepo.save(ticket);
	}
	
	@GetMapping("/getAllTicket")
	public List<Ticket> getMethodName(){
		return ticketRepo.findAll();
	}
	
	// find user by user name
	
	@GetMapping("/findBy/{username}")
	public List<Team> getMethodName(@PathVariable String username) {
//		User user=userRepository.findByUserName(username);
		return teamService.getTeamsByMember(username);
	}
	
	@GetMapping("/getCreatedBy/{name}")
	public List<Ticket> getCreatedBy(@PathVariable String name) {
		return ticketRepo.findByCreatedBy(name);
	}
	
}
