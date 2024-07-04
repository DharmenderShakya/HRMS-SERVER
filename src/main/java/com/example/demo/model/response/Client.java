package com.example.demo.model.response;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "Client_Name")
	private String name;
	
	@Column(name = "Company_name")
	private String company_name;
	
	@Column(name = "Client_Email")
	private String email;
	
	@Column(name = "Client_Mobile")
	private String mobile;
	
	@Column(name = "Date")
	private Date date;
	
	@Column(name = "currency")
	private String currency;
	
	@Column(name = "Bill_Method")
	private String bill_Method;
	
	@Column(name = "Document_file")
	private byte[] file;
	
	@OneToMany
	@JsonIgnore
	private List<Account> account;
	
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

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getBill_Method() {
		return bill_Method;
	}

	public void setBill_Method(String bill_Method) {
		this.bill_Method = bill_Method;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

}
