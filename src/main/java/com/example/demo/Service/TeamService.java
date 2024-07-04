package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.TeamRepo;
import com.example.demo.model.response.Leaders;
import com.example.demo.model.response.Team;

@Service
public class TeamService {

	@Autowired
	private TeamRepo teamrepo;
	
	@Autowired
	private LeaderService leaderService;
	
	public Team addTeam(Team team) {
		return teamrepo.save(team);
	}
	
	public List<Team> getAllTeam(){
		return teamrepo.findAll();
	}
	
	public Optional<Team> getById(int id) {
		return teamrepo.findById(id);
	}
	
	public List<Team> getTeamsByMember(String member) {
        return teamrepo.findByMember(member);
    }
}
