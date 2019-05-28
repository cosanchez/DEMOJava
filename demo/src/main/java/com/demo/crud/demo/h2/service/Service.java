package com.demo.crud.demo.h2.service;

import java.util.List;

import com.demo.crud.demo.h2.model.domain.Users;

public interface Service {
	public List<Users> getClients();
	
	public Users createClient(Users client);
	
	public Users updateClient(Users client);
	
	public Users getClientById(Long id);
	
	public void deleteClientById(Long id);
}
