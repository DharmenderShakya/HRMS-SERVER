package com.example.demo.model.response;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EstimatesProject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String projectName;
	
	private String type;
	
	private String openTask;
	
	private String leadName;
	
	private String clientName;
	
	private String progress;
	
	private String status_By_Client;
	
	private String lastModify;
	
	private String createDate;
	
	private String deadLine;
	
	private String country;
	
	private String status_By_Employee;
	
	private String details;
	
	private String priority;
	
	private String department;
	
	private String price;
	
	private byte[] file;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOpenTask() {
		return openTask;
	}

	public void setOpenTask(String openTask) {
		this.openTask = openTask;
	}

	public String getLeadName() {
		return leadName;
	}

	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}


	public String getLastModify() {
		return lastModify;
	}

	public void setLastModify(String lastModify) {
		this.lastModify = lastModify;
	}

	
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getStatus_By_Client() {
		return status_By_Client;
	}

	public void setStatus_By_Client(String status_By_Client) {
		this.status_By_Client = status_By_Client;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStatus_By_Employee() {
		return status_By_Employee;
	}

	public void setStatus_By_Employee(String status_By_Employee) {
		this.status_By_Employee = status_By_Employee;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}
	
	
	
}
