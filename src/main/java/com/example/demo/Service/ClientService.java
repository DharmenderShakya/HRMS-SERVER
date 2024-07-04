package com.example.demo.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.ClientRepo;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.UserRoleRepository;
import com.example.demo.model.response.Client;
import com.example.demo.model.response.Role;
import com.example.demo.model.response.User;
import com.example.demo.model.response.UserRole;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepo clientRepo;
	
	@Autowired
	private UserRoleRepository userRoleRepository ;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Client addClient(Client client) {
		User user=new User();
		user.setFirstName(client.getName());
		user.setEmail(client.getEmail());
		user.setUserName(client.getName()+"1234");
		user.setPhone(client.getMobile());
		user.setPassword(bCryptPasswordEncoder.encode(String.valueOf(123)));
		System.out.println("the client password is "+" "+user.getPassword());
		UserRole userRole=new UserRole();
		Role role=new Role();
		role.setRole("CLIENT");
		userRole.setRole(role);
		userRole.setEmployee(user);
		userRoleRepository.save(userRole);
		Set<UserRole> userRoleSet=new HashSet<>();
		userRoleSet.add(userRole);
		user.setUserRole(userRoleSet);
		userRepository.save(user);
		
		return clientRepo.save(client);
	}
	
	public List<Client> getAllClient(){
		return clientRepo.findAll();
	}
	
	public Optional<Client> getById(int id) {
		return clientRepo.findById(id);
	}

}
