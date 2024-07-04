package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.response.Candidate;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate, Integer> {

}
