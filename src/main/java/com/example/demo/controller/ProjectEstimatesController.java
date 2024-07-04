package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.EstimatesRepo;
import com.example.demo.Service.EstimateService;
import com.example.demo.model.response.EstimatesProject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RequestMapping("/hrms")
@RestController
@CrossOrigin("*")
public class ProjectEstimatesController {

	@Autowired
	private EstimateService estimateService;
	
	@Autowired
	private EstimatesRepo estimatesRepo;
	
	@PostMapping("/addestimates")
	public EstimatesProject postEstimateProject(@RequestBody EstimatesProject estimates) {
		estimates.setDeadLine(estimates.getLastModify());
		return estimateService.addEstimateProject(estimates);
	}
	
	
	@GetMapping("/getAllEstimates")
	public List<EstimatesProject> getAllEstimates() {
		return estimateService.getAllEstimates();
	}
	
	@GetMapping("/getEstimatesById")
	public Optional<EstimatesProject> getMethodName(@PathVariable int id) {
		return estimatesRepo.findById(id);
	}
	@GetMapping("/client/{name}")
	public List<EstimatesProject> getProjectByClientName(@PathVariable String name) {
		return estimatesRepo.findByClientName(name);
	}
	
}
