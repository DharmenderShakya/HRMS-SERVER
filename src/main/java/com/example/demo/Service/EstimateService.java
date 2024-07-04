package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EstimatesRepo;
import com.example.demo.model.response.EstimatesProject;

@Service
public class EstimateService {

	@Autowired
	private EstimatesRepo estimatesRepo;
	
	public EstimatesProject addEstimateProject(EstimatesProject estimate) {
		return estimatesRepo.save(estimate);
	}
	
	public List<EstimatesProject> getAllEstimates(){
	
		return estimatesRepo.findAll();
	}
	
	public Optional<EstimatesProject> getprojectById(int id) {
		
		return estimatesRepo.findById(id);
	}
}
