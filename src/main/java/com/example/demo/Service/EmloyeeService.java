package com.example.demo.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Repository.LeadersRepo;
import com.example.demo.Repository.ProjectRepository;
import com.example.demo.Repository.SalaryRepo;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.UserRoleRepository;
import com.example.demo.model.response.Employee;
import com.example.demo.model.response.Leaders;
import com.example.demo.model.response.Project;
import com.example.demo.model.response.Role;
import com.example.demo.model.response.User;
import com.example.demo.model.response.UserRole;

@Service
public class EmloyeeService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository; 
	
	@Autowired
	private SalaryRepo salaryRepo;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRoleRepository userRoleRepository ;
	
	@Autowired
	private LeadersRepo leadersRepo;
	@Autowired
	private UserService userService;
	
	private int count=1;
	public Employee saveEmployee(Employee employee) {
		User user=new User();
		employee.setEmpId(new Random().nextInt(1000));
		user.setFirstName(employee.getName());
		user.setEmail(employee.getEmail());
		user.setUserName(employee.getName()+"1234");
		user.setPhone(employee.getPhone_no());
		user.setPassword(employee.getPassword());
		if(employee.getRole().toUpperCase().contains("ADMIN") || employee.getRole().toUpperCase().contains("MANAGER") ||
				employee.getRole().toUpperCase().contains("HR") || employee.getRole().toUpperCase().contains("LEADER")) {
			 String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
		UserRole userRole=new UserRole();
		Role role=new Role();
		if(employee.getRole().toUpperCase().contains("ADMIN")) {
			role.setRole("ADMIN");	
		}
		else if(employee.getRole().toUpperCase().contains("MANAGER")) {
			role.setRole("MANAGER");
		}
		else if(employee.getRole().toUpperCase().contains("HR")) {
			role.setRole("HR");
		}
		else if(employee.getRole().toUpperCase().contains("LEADER")) {
			role.setRole("LEADER");
		}
		else {
			role.setRole("EMPLOYEE");	
		}
		userRole.setRole(role);
		userRole.setEmployee(user);
		userRoleRepository.save(userRole);
		Set<UserRole> userRoleSet=new HashSet<>();
		userRoleSet.add(userRole);
		user.setUserRole(userRoleSet);
		userRepository.save(user);
		}
		else{
			userService.addUser(user);
		}
		
		if(employee.getRole().contains("leader")) {
			Leaders leader=new Leaders();
			leader.setDepartment(employee.getDepartment());
			leader.setEmail(employee.getEmail());
			leader.setName(employee.getName());
			leader.setMobile(employee.getPhone_no());
			leader.setRole(employee.getRole());
			leadersRepo.save(leader);
		}
		return  employeeRepository.save(employee);
	}
	
//	public Page<Employee> getEmployee( Pageable pageable){
//		return employeeRepository.findAll(pageable);
//	}
	
	public List<Employee> getEmployee(){
		
		return employeeRepository.findAll();
	}
	
	
	public Optional<Employee> getByEmployeeId(int empId) {
		
		return employeeRepository.findById(empId);
	}
	
	public Employee saveOrUpdate(int empId,Employee employee) {
		
		Employee emp=employeeRepository.findById(empId).get();
		emp.setEmail(employee.getEmail());
		emp.setName(employee.getName());
		emp.setPhone_no(employee.getPhone_no());
		 return employeeRepository.save(emp);
	}
	
	
		
		public void assignEmployeeProject(int empId,int projectId) {
				
		Employee user=employeeRepository.findById(empId).get();
		Project role=projectRepository.findById(projectId).get();
//		user.getRoles().add(role);
		
		projectRepository.save(role);
			
		}
		
		public void deleteEmployee(int id) {
			employeeRepository.deleteById(id);
		}
		
		public Employee getEmployeeByName(String name) {
			return employeeRepository.findEmployeeByName(name);
		}
		
		public List<Employee> findEmployeesByNames(List<String> names) {
	        return employeeRepository.findByNameIn(names);
	    }
		
}
