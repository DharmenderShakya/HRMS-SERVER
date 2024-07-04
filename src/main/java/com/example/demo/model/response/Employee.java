package com.example.demo.model.response;

import java.util.List;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int  id;
	private int empId;
	@Column(name="Employee_FirstName")
	private String name;
	@Column(name="Employee_Deparment")
	private  String department;
	@Column(name="Employee_email")
	private String email;
	@Column(name="Employee_Address")
	private String employe_address;
	@Column(name="Employee_Role")
	private String employee_role;
	@Column(name="Phone_NO")
	private String phone_no;
	@Column(name="Employee_password")
	private String password;
	@Column(name="Employee_DateOfBirth")
	private String dateOfBirth;
	@Column(name="Employee_DateOfJoining")
	private String dateOfJoining;
	private String gender;
	
	@Lob
	@Column(nullable = true)
	private byte[] image;
	

@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinTable(
        name = "Employee_Project",
        joinColumns = @JoinColumn(name="Employee_id",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="Project_id",referencedColumnName = "id")
)
private Set<Project> project;

	@OneToMany
	private Set<Account> account;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Salary> salaries;
	
	@OneToOne(cascade = CascadeType.ALL)
	private LeaveBalence balence;
	
	@ManyToOne
	private Team team;
	
	@OneToOne
	private Attendance attedance; 
	
	@OneToMany
	private List<PaidSalary> paidSalary;
	
	@OneToMany
	private List<Jobs> jobs;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Expense> expense;
	
	@OneToMany
	private List<Ticket> tickets;
	

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
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getEmploye_address() {
	return employe_address;
}
public void setEmploye_address(String employe_address) {
	this.employe_address = employe_address;
}
public String getRole() {
	return employee_role;
}
public void setRole(String employee_role) {
	this.employee_role = employee_role;
}

public String getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(String dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public String getDateOfJoining() {
	return dateOfJoining;
}
public void setDateOfJoining(String dateOfJoining) {
	this.dateOfJoining = dateOfJoining;
}
public Set<Project> getProject() {
	return project;
}
public void setProject(Set<Project> project) {
	this.project = project;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public String getPhone_no() {
	return phone_no;
}
public void setPhone_no(String phone_no) {
	this.phone_no = phone_no;
}


public Employee(int id, int empId, String name, String department, String email, String employe_address,
		String employee_role, String phone_no, String password, String dateOfBirth, String dateOfJoining, String gender,
		byte[] image, Set<Project> project, Set<Account> account, Set<Salary> salaries, LeaveBalence balence,
		Team team, Attendance attedance, List<PaidSalary> paidSalary, List<Jobs> jobs, List<Expense> expense,
		List<Ticket> tickets) {
	super();
	this.id = id;
	this.empId = empId;
	this.name = name;
	this.department = department;
	this.email = email;
	this.employe_address = employe_address;
	this.employee_role = employee_role;
	this.phone_no = phone_no;
	this.password = password;
	this.dateOfBirth = dateOfBirth;
	this.dateOfJoining = dateOfJoining;
	this.gender = gender;
	this.image = image;
	this.project = project;
	this.account = account;
	this.salaries = salaries;
	this.balence = balence;
	this.team = team;
	this.attedance = attedance;
	this.paidSalary = paidSalary;
	this.jobs = jobs;
	this.expense = expense;
	this.tickets = tickets;
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEmployee_role() {
	return employee_role;
}
public void setEmployee_role(String employee_role) {
	this.employee_role = employee_role;
}
public byte[] getImage() {
	return image;
}
public void setImage(byte[] image) {
	this.image = image;
}
public Set<Account> getAccount() {
	return account;
}
public void setAccount(Set<Account> account) {
	this.account = account;
}
public Set<Salary> getSalaries() {
	return salaries;
}
public void setSalaries(Set<Salary> salaries) {
	this.salaries = salaries;
}
public LeaveBalence getBalence() {
	return balence;
}
public void setBalence(LeaveBalence balence) {
	this.balence = balence;
}
public Team getTeam() {
	return team;
}
public void setTeam(Team team) {
	this.team = team;
}
public Attendance getAttedance() {
	return attedance;
}
public void setAttedance(Attendance attedance) {
	this.attedance = attedance;
}
public List<PaidSalary> getPaidSalary() {
	return paidSalary;
}
public void setPaidSalary(List<PaidSalary> paidSalary) {
	this.paidSalary = paidSalary;
}
public List<Jobs> getJobs() {
	return jobs;
}
public void setJobs(List<Jobs> jobs) {
	this.jobs = jobs;
}
public List<Expense> getExpense() {
	return expense;
}
public void setExpense(List<Expense> expense) {
	this.expense = expense;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public List<Ticket> getTickets() {
	return tickets;
}
public void setTickets(List<Ticket> tickets) {
	this.tickets = tickets;
}

public String ignorCase(String a) {
	System.out.println("this is the string in upper case"+a.toUpperCase());
	return a.toLowerCase();
}


}
