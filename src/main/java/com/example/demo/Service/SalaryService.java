package com.example.demo.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Repository.SalaryRepo;
import com.example.demo.model.response.Employee;
import com.example.demo.model.response.Salary;

@Service
public class SalaryService {
	
@Autowired
private SalaryRepo salaryRepo;

@Autowired
private EmloyeeService emploEmloyeeService;


public Salary saveSalary(Salary salary) {
	return salaryRepo.save(salary);
}

public List<Salary> getAllSalaryDetails(){
	
	return salaryRepo.findAll();
}

public Optional<Salary> salaryGetById(int salaryId) {
	
	return salaryRepo.findById(salaryId);
}

public  void SalaryDeleteById(int salaryId) {
	
	salaryRepo.deleteById(salaryId);
}
}
