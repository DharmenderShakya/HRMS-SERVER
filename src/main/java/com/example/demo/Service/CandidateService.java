package com.example.demo.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CandidateRepo;
import com.example.demo.model.response.Candidate;


@Service
public class CandidateService {

	@Autowired
	private CandidateRepo candidateRepo;
	
	public Candidate addCandidate(Candidate candidate) {
		return candidateRepo.save(candidate);
	}
	
	public List<Candidate> getAll(){
		
		return candidateRepo.findAll();
	}

	public Optional<Candidate> findById(int id) {
		return candidateRepo.findById(id);
	}
	
}
