package com.example.demo.model.response;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "Project_Id",nullable = false)
	private String project_Id="pro00"+id;
	
	@Column(name="project_name")
	private String name;
	
	@Column(name="Project_Start_Date")
	private String startDate;
	
	@Column(name="Project_EndDate")
	private String endDate;
	
	@Column(name = "Project_DepartMent")
	private String project_Deparment;
	
	@Column(name = "Project_priority")
	private String priority;
	
	@Column(name="Project_Description")
	private String projectDescription;
	
	@Column(name = "teamleader")
	private String teamLeader;
	
	@Column(name = "project_price")
	private int price;
	
	@Column(name="client")
	private String client;
	
	@Column(name = "project_status")
	private String status;
	
	@Column(name = "project_file")
	private byte[] file;
	
	@ManyToOne
	@JsonIgnore
	Employee employee;
	
	public String getTeamLeader() {
		return teamLeader;
	}
	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}
	public int getId() {
	return id;
		}
	public void setId(int id) {
	this.id = id;
		}
	public String getName() {
	return name;
		}
	public void setName(String name) {
		this.name = name;
	}
	public String getProject_Id() {
		return project_Id;
	}
	public void setProject_Id(String project_Id) {
		this.project_Id = project_Id;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getProject_Deparment() {
		return project_Deparment;
	}
	public void setProject_Deparment(String project_Deparment) {
		this.project_Deparment = project_Deparment;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
