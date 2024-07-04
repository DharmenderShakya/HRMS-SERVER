package com.example.demo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.response.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {

	public List<Ticket> findByCreatedBy(String name);
}
