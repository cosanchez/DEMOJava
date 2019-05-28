package com.demo.crud.demo.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.crud.demo.h2.model.domain.Users;
import com.demo.crud.demo.h2.service.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class Controller {

	@Autowired
	private Service service;

	@GetMapping(value = "/getUsers")
	public List<Users> getAllClients() {

		return service.getClients();
	}

	@PostMapping(value = "createUser")
	public Users createClient(@RequestBody Users client) {

		log.info("Client received  by request body client: " + client);

		return service.createClient(client);
	}

	@PutMapping(value = "updateUser")
	public Users updateClient(@RequestBody Users client) {

		log.info("Client received  by request body client: " + client);

		return service.updateClient(client);
	}

	@GetMapping(value = "/getUserById/{id}")
	public Users GetClientByID(@PathVariable("id") long id) {

		log.info("id received  by URL :id: " + id);

		return service.getClientById(id);

	}

	@DeleteMapping(value = "/deleteUser/{id}")
	public void deleteClientById(@PathVariable("id") Long id) {

		log.info("id received by URL :id: " + id);
		service.deleteClientById(id);

	}

}
