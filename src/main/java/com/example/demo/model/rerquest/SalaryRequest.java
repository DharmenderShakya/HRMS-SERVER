package com.example.demo.model.rerquest;

import java.util.Date;

import com.example.demo.model.response.Employee;

import jakarta.persistence.ManyToOne;

public class SalaryRequest {
	private int id;
	private String name;
	private String email;
	private String department;
	private String role;
	private int employee_salary;
	private String status="UNPAID";
	private int paidSalary;
	private Date date;
    private Employee employee;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getEmployee_salary() {
		return employee_salary;
	}
	public void setEmployee_salary(int employee_salary) {
		this.employee_salary = employee_salary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPaidSalary() {
		return paidSalary;
	}
	public void setPaidSalary(int paidSalary) {
		this.paidSalary = paidSalary;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    
}
