package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.AccountRepo;
import com.example.demo.Service.AccountServcie;
import com.example.demo.Service.EmloyeeService;
import com.example.demo.model.response.Account;
import com.example.demo.model.response.Employee;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/hrms")
@CrossOrigin("*")
public class AccountPaymentController {

	@Autowired
	private EmloyeeService empEmloyeeService;
	
	@Autowired
	private AccountServcie accountServcie;
	
	@Autowired
	private AccountRepo accountRepo;
	
	
	@PostMapping("/post")
	public Account postMethodName(@RequestBody Account account) {
		return accountServcie.addbill(account);
	}
	
	@GetMapping("/getAllPayment")
	public List<Account> getPaymentDetails() {
		return accountServcie.getAllAccount();
	}
	@PutMapping("/updatePayment")
	public Account putMethodName(@RequestBody Account entity) {
		Account account=accountRepo.findById(entity.getId()).get();
		account.setBillNo(entity.getBillNo());
		account.setCharges(entity.getCharges());
		account.setClient(entity.getClient());
		account.setClientName(entity.getClientName());
		account.setDate(entity.getDate());
		account.setDiscount(entity.getDiscount());
		account.setEmployee(entity.getEmployee());
		account.setEmployee_Name(entity.getEmployee_Name());
		account.setTax(entity.getTax());
		account.setTotal(entity.getTotal());
		return accountRepo.save(account);
	}
	@GetMapping("/getPayment/{name}")
	public List<Account> getMethodName(@PathVariable String name) {
		return accountRepo.findAccountByClientName(name);
	}
	
	
}
