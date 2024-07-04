package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.ClientRepo;
import com.example.demo.Service.ClientService;
import com.example.demo.model.response.Client;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RequestMapping("/hrms")
@RestController
@CrossOrigin("*")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ClientRepo clientRepo;
	
	@PostMapping("/client")
	public Client postClient(@RequestBody Client service) {
		service.setDate(new Date());
		return clientService.addClient(service);
	}
	@PostMapping("/clientALL")
	public List<Client> postAllClient(@RequestBody List<Client> service) {	
		return clientRepo.saveAll(service);
	}
	
	@GetMapping("/allclient")
	public List<Client> getClient() {
		return clientService.getAllClient();
	}
	
	@GetMapping("/clientById")
	public Optional<Client> getClientById(@RequestParam int id) {
		return clientService.getById(id);
	}
	
	
	

}
