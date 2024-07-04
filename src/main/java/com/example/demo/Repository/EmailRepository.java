package com.example.demo.Repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.response.Email;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer> {
	List<Email>findByRecipient(String findByRecipient);
}

