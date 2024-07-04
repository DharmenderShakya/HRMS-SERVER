package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.response.PaidSalary;

@Repository
public interface PaidSalaryRepo extends JpaRepository<PaidSalary, Integer> {

}
