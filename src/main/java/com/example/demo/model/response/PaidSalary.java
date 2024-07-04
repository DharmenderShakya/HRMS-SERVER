package com.example.demo.model.response;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PaidSalary {
@Id
private int id;
private String name;
private String salaryStatus;
private String paidSalary;

@ManyToOne
private Employee employee;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSalaryStatus() {
	return salaryStatus;
}
public void setSalaryStatus(String salaryStatus) {
	this.salaryStatus = salaryStatus;
}
public String getPaidSalary() {
	return paidSalary;
}
public void setPaidSalary(String paidSalary) {
	this.paidSalary = paidSalary;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}


}
