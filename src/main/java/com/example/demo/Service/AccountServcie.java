package com.example.demo.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.AccountRepo;
import com.example.demo.Repository.ClientRepo;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.model.response.Account;
import com.example.demo.model.response.Client;
import com.example.demo.model.response.Employee;

@Service
public class AccountServcie {

	@Autowired
	private AccountRepo accountRepo;
	
	@Autowired
	private ClientRepo clientRepo;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Account addbill(Account acc){
		Client client=clientRepo.findClientByName(acc.getClientName());
		Account account2=new Account();
		account2.setClientName(acc.getClientName());
		account2.setEmployee_Name(acc.getEmployee_Name());
		account2.setClient(client);
		account2.setBillNo(new Random().nextInt(1000));
		account2.setCharges(acc.getCharges());
		account2.setDate(new Date());
		account2.setDiscount(acc.getDiscount());
		Employee employee=employeeRepository.findEmployeeByName(acc.getEmployee_Name());
		account2.setEmployee(employee);
		account2.setDiscount(acc.getDiscount());
		account2.setTax(acc.getTax());
		account2.setTotal(acc.getTotal());
		return accountRepo.save(account2);
	}
	
	public List<Account> getAllAccount(){
		return accountRepo.findAll();
	}
	
	public Optional<Account> getAccountById(int id) {
		return accountRepo.findById(id);
	}
}
