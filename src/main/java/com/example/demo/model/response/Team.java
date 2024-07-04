package com.example.demo.model.response;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String teamName;
	
	 @ElementCollection
	private List<String> member;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Employee> employee;
	
	@ManyToOne
    @JoinColumn(name = "leader_id")
    private Leaders leader;
	
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Ticket> tasks = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<String> getMember() {
		return member;
	}

	public void setMember(List<String> member) {
		this.member = member;
	}

	public Leaders getLeader() {
		return leader;
	}

	public void setLeader(Leaders leader) {
		this.leader = leader;
	}

	public Set<Ticket> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Ticket> tasks) {
		this.tasks = tasks;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee2) {
		this.employee = employee2;
	}

}
