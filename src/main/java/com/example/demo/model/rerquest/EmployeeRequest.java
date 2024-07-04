package com.example.demo.model.rerquest;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;

public class EmployeeRequest {
	private String firstName;
	private  String department;
	private String email;
	private String employe_address;
	private String employee_role;
	private String phone_no;
	private String password;
	private Date dateOfBirth;
	private Date DateOfJoining;
	@Lob
	@Column(nullable = true)
	private byte[] image;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmploye_address() {
		return employe_address;
	}
	public void setEmploye_address(String employe_address) {
		this.employe_address = employe_address;
	}
	public String getEmployee_role() {
		return employee_role;
	}
	public void setEmployee_role(String employee_role) {
		this.employee_role = employee_role;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getDateOfJoining() {
		return DateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		DateOfJoining = dateOfJoining;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
}
