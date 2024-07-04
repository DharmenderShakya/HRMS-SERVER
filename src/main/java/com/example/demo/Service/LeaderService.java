package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.LeadersRepo;
import com.example.demo.model.response.Leaders;

@Service
public class LeaderService {
	
	@Autowired
	private LeadersRepo leaderRepo;

	public List<Leaders> getAllLeaders(){
		return leaderRepo.findAll();
	}
	
	public Leaders addLeaders(Leaders leader){
		
		return leaderRepo.save(leader);
	}
	
	public Optional<Leaders> findById(int id) {
		
		return leaderRepo.findById(id);
	}
	
	public Leaders findByLeaderName(String name) {
		return leaderRepo.findLeadersByName(name);
	}
}
