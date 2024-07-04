package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.UserRoleRepository;
import com.example.demo.Service.UserService;
import com.example.demo.model.response.Role;
import com.example.demo.model.response.User;
import com.example.demo.model.response.UserRole;

@RestController
@RequestMapping("/hrms")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService ;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/")
	public User createUser(@RequestBody  User user) {
		return userService.addUser(user);
	}
	
	@GetMapping("/{name}")
	public User getUsers(@PathVariable String name){
		
		return userRepository.findByUserName(name);
	}
		
		@GetMapping("/all")
		public List<User> geAlltUsers(){
			
			return userRepository.findAll();
		
	}
	
	
}
