package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.response.LeaveTypes;

@Repository
public interface LeaveTypeRepo extends JpaRepository<LeaveTypes, Integer> {

}
