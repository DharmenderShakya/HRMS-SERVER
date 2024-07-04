package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.SalaryRepo;
import com.example.demo.Service.EmloyeeService;
import com.example.demo.Service.SalaryService;
import com.example.demo.model.response.Employee;
import com.example.demo.model.response.Salary;

@RestController
@RequestMapping("/hrms")
@CrossOrigin("*")
public class SalaryController {

	@Autowired
 private SalaryService  salaryService;
	
	@Autowired
	private EmloyeeService emloyeeService;
	
	@Autowired
	private SalaryRepo salaryRepo;
	
	@PostMapping("/addSalary")
	public Salary saveSalary(@RequestBody Salary salary) {
		Employee employee=emloyeeService.getEmployeeByName(salary.getName());
		Salary salary2=new Salary();
		salary2.setDate(new Date());
		salary2.setStatus("UNAPID");
		salary2.setName(employee.getName());
		salary2.setDepartment(salary.getDepartment());
		salary2.setEmail(salary.getEmail());
		salary2.setEmployee(employee);
		salary2.setEmployee_salary(salary.getEmployee_salary());
		salary2.setRole(salary.getRole());
		return salaryService.saveSalary(salary2);
	}
	
	@GetMapping("/getSalary")
	public  List<Salary> getAllSalaryDetails() {
		return salaryService.getAllSalaryDetails();
	}
	@GetMapping("/salaryGetById/{salaryId}")
	public ResponseEntity<Salary> salaryGetById(@PathVariable int salaryId) {
		return ResponseEntity.of(salaryService.salaryGetById(salaryId)); 
	}
	
	@PutMapping("/updateSalary")
	public void updateSalaryDetails(@RequestBody Salary salary) {
		Salary salary2=salaryRepo.findById(salary.getId()).get();
		salary2.setDate(salary.getDate());
		salary2.setDepartment(salary.getDepartment());
		salary2.setEmail(salary.getEmail());
		salary2.setEmployee_salary(salary.getEmployee_salary());
		salary2.setName(salary.getName());
		salary2.setRole(salary.getRole());
		salary2.setStatus(salary.getStatus());
		salaryService.saveSalary(salary2);
	}
	
	
	@DeleteMapping("/deleteSalaryById/{salaryId}")
	public void deleteSalaryById(@PathVariable int salaryId) {
		salaryService.SalaryDeleteById(salaryId);
	}
}
