package com.example.demo.model.rerquest;

import java.util.List;
import java.util.Map;

import com.example.demo.model.response.Employee;

public class TeamRequest {

	private int id;
	private String teamName;
	private String leaderName;
	private List<Map<String,Employee>> member;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public List<Map<String, Employee>> getMember() {
		return member;
	}
	public void setMember(List<Map<String, Employee>> member) {
		this.member = member;
	}
	
	
	
}
