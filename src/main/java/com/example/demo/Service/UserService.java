package com.example.demo.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.UserRoleRepository;
import com.example.demo.model.response.Role;
import com.example.demo.model.response.User;
import com.example.demo.model.response.UserRole;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRoleRepository userRoleRepository ;
	
	public User addUser(User user) {
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		Set<UserRole> userRoleSet=new HashSet<>();
		Role role=new Role();
		role.setRole("EMPLOYEE");
		UserRole userRole=new UserRole();
		userRole.setEmployee(user);
		userRole.setRole(role);
		userRoleSet.add(userRole);
		user.setUserRole(userRoleSet);
		userRoleRepository.save(userRole);
		return userRepository.save(user);
	}

    public String getCurrentRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String roles = authorities.stream()
                                  .map(GrantedAuthority::getAuthority)
                                  .collect(Collectors.joining(", "));
        return "Current logged in user's roles: " + roles;
    }
    
    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return "Current logged in user's roles: " + name;
    }
	
}
