package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.response.Team;

@Repository
public interface TeamRepo extends JpaRepository<Team, Integer>{
	
	public Team findTeamByTeamName(String leaderName);

	public Team findByTeamName(String teamName);
	
	@Query("SELECT t FROM Team t JOIN t.member m WHERE m = :member")
    List<Team> findByMember(String member);

}
