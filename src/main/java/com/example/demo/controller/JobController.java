package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Repository.CandidateRepo;
import com.example.demo.Service.CandidateService;
import com.example.demo.Service.JobService;
import com.example.demo.model.response.Candidate;
import com.example.demo.model.response.Jobs;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/hrms")
@CrossOrigin("*")
public class JobController {

	@Autowired
	private JobService jobService;
	
	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private CandidateRepo candidateRepo;
	
	@PostMapping("/jopost")
	public Jobs postMethodName(@RequestBody Jobs entity) {
		
		return jobService.addJobs(entity);
	}
	@GetMapping("/getAllJobs")
	public List<Jobs> getMethodName() {
		return jobService.getAllJobs();
	}
	
	@GetMapping("/getJob/{id}")
	public Optional<Jobs> getMethodName(@PathVariable int id) {
		return jobService.getJobsById(id);
	}
	
	@PostMapping("/cpost")
	public Candidate postCandidate(@RequestParam("name") String name,@RequestParam("email") String email,
			@RequestParam("mobile") String mobile,@RequestParam("role") String role,
			@RequestParam("jobType") String jobType,@RequestParam("jobtitle") String jobtitle,
			@RequestParam("image") MultipartFile image,@RequestParam("file") MultipartFile file) throws IOException {
		Candidate candidate=new Candidate();
		candidate.setName(name);
		candidate.setEmail(email);
		candidate.setMobile(mobile);
		candidate.setRole(role);
		candidate.setJobType(jobType);
		candidate.setJobtitle(jobtitle);
		candidate.setImage(image.getBytes());
		candidate.setFile(file.getBytes());
		return candidateService.addCandidate(candidate);
	}
	
	@GetMapping("/getAllCandidate")
	public List<Candidate> getCandidate() {
		return candidateService.getAll();
	}
	@GetMapping("/getCandidate/{id}")
	public Optional<Candidate> getcandidateById(@PathVariable int id) {
		return candidateService.findById(id);
	}
	
	@PutMapping("/updateCandidate")
	public Candidate updateCandidate(@RequestBody Candidate candidate) {
		
		return candidateRepo.save(candidate);
	}
	
}
