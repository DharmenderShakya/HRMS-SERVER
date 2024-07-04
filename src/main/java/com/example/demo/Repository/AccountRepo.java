package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.response.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {

	public List<Account> findAccountByClientName(String name);
	
}
