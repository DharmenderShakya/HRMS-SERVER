package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.response.Account;
import com.example.demo.model.response.Client;


@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {

	public Client findClientByName(String name);
	
}
