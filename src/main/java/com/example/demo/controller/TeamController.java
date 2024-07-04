package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Repository.TeamRepo;
import com.example.demo.Service.EmloyeeService;
import com.example.demo.Service.TeamService;
import com.example.demo.model.response.Employee;
import com.example.demo.model.response.Team;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@CrossOrigin("*")
@RequestMapping("/hrms")

public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private  EmloyeeService emloyeeService;
	
	@Autowired
	private TeamRepo teamRepo;

	@GetMapping("/getTeam")
	public List<Team> getMethodName() {
		return teamService.getAllTeam();
	}
	@PostMapping("/postTeam")
	public Team postMethodName(@RequestBody Team entity) {
		List<String> members=entity.getMember();
//		Team team1=teamRepo.findByTeamName(entity.getTeamName());
			List<Employee> employee=emloyeeService.findEmployeesByNames(members);
			Team team =new Team();
			team.setEmployee(employee);
			team.setMember(entity.getMember());
			team.setTeamName(entity.getTeamName());
			return teamService.addTeam(team);
//		return null;
	}
	
	

}
