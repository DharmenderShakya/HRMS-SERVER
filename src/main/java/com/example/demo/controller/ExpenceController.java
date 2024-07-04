package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ExpenseService;
import com.example.demo.model.response.Expense;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/hrms")
@CrossOrigin("*")
public class ExpenceController {
	
	@Autowired
	private ExpenseService expenseService;
	
	
	@PostMapping("/postExpence")
	public Expense postExpense(@RequestBody Expense entity) {
		expenseService.addExpence(entity);
		return entity;
	}
	
}
