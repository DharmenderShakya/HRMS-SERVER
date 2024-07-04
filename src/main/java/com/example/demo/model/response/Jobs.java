package com.example.demo.model.response;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Jobs {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String employeeName;
	@Column(name = "Job_Title")
	private String title;
	@Column(name = "Deparment")
	private String department;
	@Column(name = "Job_role")
	private String role;
	private String jobType;
	@Column(name = "Job_Vacancies")
	private String vacancies;
	@Column(name = "Job_Status")
	private String status;
	@Column(name = "Expire_Date")
	private Date date;
	@ManyToOne
	private Employee employee;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getVacancies() {
		return vacancies;
	}
	public void setVacancies(String vacancies) {
		this.vacancies = vacancies;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
}
