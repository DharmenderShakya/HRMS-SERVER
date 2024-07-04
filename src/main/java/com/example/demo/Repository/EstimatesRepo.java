package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.response.EstimatesProject;

@Repository
public interface EstimatesRepo extends JpaRepository<EstimatesProject, Integer> {

 public List<EstimatesProject> findByClientName(String name);
}
