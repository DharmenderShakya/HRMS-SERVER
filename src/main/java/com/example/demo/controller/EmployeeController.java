package com.example.demo.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Service.EmloyeeService;
import com.example.demo.Service.LeaderService;
import com.example.demo.model.rerquest.LeaderRequest;
import com.example.demo.model.response.Employee;
import com.example.demo.model.response.Leaders;
import com.example.demo.model.response.LeaveRequest;
import com.example.demo.model.response.Role;
import com.example.demo.model.response.Salary;
import com.example.demo.model.response.UserRole;

@RestController
@RequestMapping("/hrms")
@CrossOrigin("*")
public class EmployeeController {
	@Autowired
	private EmloyeeService emloyeeService;
	
	@Autowired
	private LeaderService leaderService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/addEmployee")
	public Employee addUser(@RequestParam("name") String name,
			@RequestParam("department") String department,
			@RequestParam("email") String email,
			@RequestParam("employe_address") String employe_address,
			@RequestParam("employee_role") String employee_role,
			@RequestParam("phone_no") String phone_no,
			@RequestParam("password") String password,
			@RequestParam("dateOfBirth") String dateOfBirth,
			@RequestParam("dateOfJoining") String dateOfJoining,
			@RequestParam("gender") String gender,
			@RequestPart("file") MultipartFile file) throws IOException {
		Employee employee=new Employee();
		employee.setName(name);
		employee.setDepartment(department);
		employee.setEmail(email);
		employee.setEmploye_address(employe_address);
		employee.setEmployee_role(employee_role);
		employee.setPhone_no(phone_no);
		employee.setPassword(password);
		employee.setDateOfBirth(dateOfBirth);
		employee.setDateOfJoining(dateOfJoining);
		employee.setGender(gender);
		employee.setImage(file.getBytes());
		return emloyeeService.saveEmployee(employee);
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateUser(@RequestParam("name") String name,
			@RequestParam("id") int id,
			@RequestParam("department") String department,
			@RequestParam("email") String email,
			@RequestParam("employe_address") String employe_address,
			@RequestParam("employee_role") String employee_role,
			@RequestParam("phone_no") String phone_no,
			@RequestParam("password") String password,
			@RequestParam("dateOfBirth") String dateOfBirth,
			@RequestParam("dateOfJoining") String dateOfJoining,
			@RequestParam("gender") String gender,
			@RequestPart("file") MultipartFile file) throws IOException {
		Employee employee=employeeRepository.findById(id).get();
		employee.setName(name);
		employee.setDepartment(department);
		employee.setEmail(email);
		employee.setEmploye_address(employe_address);
		employee.setEmployee_role(employee_role);
		employee.setPhone_no(phone_no);
		employee.setPassword(password);
		employee.setDateOfBirth(dateOfBirth);
		employee.setDateOfJoining(dateOfJoining);
		employee.setGender(gender);
		employee.setImage(file.getBytes());
		return emloyeeService.saveEmployee(employee);
	}
	
	
//	@GetMapping("/getEmployee")
//	public Page<Employee> getAllEmployee(Pageable pageable){
//		return emloyeeService.getEmployee(pageable);
//	}
	@GetMapping("/getEmployeeDetails")
	public List<Employee> getAllEmployee(){
		return emloyeeService.getEmployee();
	}
	
	@GetMapping("/getById/{empId}")
	public ResponseEntity<Employee> getEmployeeId(@PathVariable int empId) {
		return ResponseEntity.of(emloyeeService.getByEmployeeId(empId));
	}
	
	@PutMapping("/updateEmployee/{id}")
	public Employee saveUpdateEmployee(@PathVariable int id ,@RequestBody Employee employee) {
		return emloyeeService.saveOrUpdate(id, employee);
	}
	
	@PostMapping("/getDetails/{empId}/project/{projectId}")
	public void saveAssignDetails(@PathVariable int empId,@PathVariable int projectId) {
		emloyeeService.assignEmployeeProject(empId, projectId);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public void  deleteEmployee(@PathVariable int id) {
		employeeRepository.deleteById(id);
	}
	
	@PostMapping("/postLeaders")
	public Leaders postMethodName(@RequestBody LeaderRequest leaders) {
		Leaders leaders2=new Leaders();
		leaders2.setDepartment(leaders.getDepartment());
		leaders2.setEmail(leaders.getEmail());
		leaders2.setMobile(leaders.getPhone_no());
		leaders2.setName(leaders.getName());
		leaders2.setRole(leaders.getEmployee_role());
		Employee employee=new Employee();
		employee.setName(leaders.getName());
		employee.setDepartment(leaders.getDepartment());
		employee.setEmail(leaders.getEmail());
		employee.setEmployee_role(leaders.getEmployee_role());
		employee.setPhone_no(leaders.getPhone_no());
		employee.setEmploye_address(leaders.getEmploye_address());
//		employee.setDateOfBirth(leaders.getDateOfBirth());
//		employee.setDateOfJoining(leaders.getDateOfJoining());
		employee.setPassword(String.valueOf(new Random().nextInt(50000)) );
		emloyeeService.saveEmployee(employee);
		return leaderService.addLeaders(leaders2);
	}
	@GetMapping("/getEmployeeByName/{name}")
	public Employee postMethodName(@PathVariable String name) {
		return employeeRepository.findEmployeeByName(name);
	}
	
	
	
}
