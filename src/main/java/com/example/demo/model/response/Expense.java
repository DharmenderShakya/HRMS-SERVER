package com.example.demo.model.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String assignBy;
	private int invoice_no;
	private Date expence_date;
	private String expense;
	private String expence_by;
	private int expence_amount;
	private String paymentMode;
	private String paymentStatus;
	private String paidTo;
	
	@ManyToOne
	private Employee employee;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInvoice_no() {
		return invoice_no;
	}
	public void setInvoice_no(int invoice_no) {
		this.invoice_no = invoice_no;
	}
	public Date getExpence_date() {
		return expence_date;
	}
	public void setExpence_date(Date expence_date) {
		this.expence_date = expence_date;
	}
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public String getExpence_by() {
		return expence_by;
	}
	public void setExpence_by(String expence_by) {
		this.expence_by = expence_by;
	}
	public int getExpence_amount() {
		return expence_amount;
	}
	public void setExpence_amount(int expence_amount) {
		this.expence_amount = expence_amount;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaidTo() {
		return paidTo;
	}
	public void setPaidTo(String paidTo) {
		this.paidTo = paidTo;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getAssignBy() {
		return assignBy;
	}
	public void setAssignBy(String assignBy) {
		this.assignBy = assignBy;
	}
	
	
	
}
