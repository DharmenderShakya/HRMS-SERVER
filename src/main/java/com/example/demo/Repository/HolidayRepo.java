package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.response.Holiday;

@Repository
public interface HolidayRepo extends JpaRepository<Holiday, Integer>{

	 
}
