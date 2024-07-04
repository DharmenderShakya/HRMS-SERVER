package com.example.demo.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.JobRepo;
import com.example.demo.model.response.Employee;
import com.example.demo.model.response.Jobs;

@Service
public class JobService {

	@Autowired
	private JobRepo jobRepo;
	
	@Autowired
	private EmloyeeService emplEmloyeeService;
	
	public Jobs addJobs(Jobs jobs) {
		Employee employee=emplEmloyeeService.getEmployeeByName(jobs.getEmployeeName());
		Jobs jobs2=new Jobs();
		jobs2.setEmployee(employee);
		jobs2.setDate(new Date());
		jobs2.setDepartment(jobs.getDepartment());
		jobs2.setEmployeeName(jobs.getEmployeeName());
		jobs2.setJobType(jobs.getJobType());
		jobs2.setRole(jobs.getRole());
		jobs2.setStatus(jobs.getStatus());
		jobs2.setTitle(jobs.getTitle());
		jobs2.setVacancies(jobs.getVacancies());
		return jobRepo.save(jobs2);
	}
	
	public List<Jobs> getAllJobs(){
		return jobRepo.findAll();
	}
	
	public Optional<Jobs> getJobsById(int id) {
		return jobRepo.findById(id);
	}
}
