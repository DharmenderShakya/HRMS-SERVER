package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ExpenseRepo;
import com.example.demo.model.response.Employee;
import com.example.demo.model.response.Expense;

@Service
public class ExpenseService  {

	@Autowired
	private ExpenseRepo expenseRepo;
	
	@Autowired
	private EmloyeeService emploEmloyeeService;
	
	public Expense addExpence(Expense expense) {
		Employee employee=emploEmloyeeService.getEmployeeByName(expense.getExpence_by());
		System.out.println("this the employee details"+employee.getName()+"  "+employee.getDateOfBirth());
		Expense expense2=new Expense();
		expense2.setEmployee(employee);
		expense2.setAssignBy(expense.getAssignBy());
		expense2.setExpence_amount(expense.getExpence_amount());
		expense2.setExpence_by(expense.getExpence_by());
		expense2.setExpence_date(expense.getExpence_date());
		expense2.setExpense(expense.getExpense());
		expense2.setInvoice_no(new Random().nextInt(1000));
		expense2.setPaidTo(expense.getPaidTo());
		expense2.setPaymentMode(expense.getPaymentMode());
		expense2.setPaymentStatus(expense.getPaymentStatus());
		return expenseRepo.save(expense2);
	}
	public List<Expense> getAllExpence(){
		return expenseRepo.findAll();
	}
	
	public Optional<Expense> getExpenceById(int id) {
		return expenseRepo.findById(id);
	}
}
