package com.demo.crud.demo.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.crud.demo.h2.mapper.Transformer;
import com.demo.crud.demo.h2.model.dao.H2ClientDao;
import com.demo.crud.demo.h2.model.domain.Users;
import com.demo.crud.demo.h2.repository.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

	@Autowired
	private Repository repo;

	@Autowired
	private Transformer transformer;

	public List<Users> getClients() {
		
		log.info(":: GET   getClients  SERVICE ::  DB INFO {} ", repo.findAll());
		
		return transformer.transformToClientList(repo.findAll());
	}

	public Users createClient(Users client) {
		
		log.info(":: Create   Client  SERVICE ::  RB INFO {} ", client);
		
		H2ClientDao clientDao = transformer.transformToDao(client);
		log.info(":: transform from client object to client DAO object ::  Transf INFO {} " , clientDao);
		
		clientDao = repo.save(clientDao);

		log.info(":: Create   Client  SERVICE ::  DB INFO {} ", clientDao);
		
		return transformer.transformToClient(clientDao);
	}

	public Users updateClient(Users client) {
		log.info(":: Update   Client  SERVICE ::  RB INFO {} ", client);
		
		H2ClientDao clientDao = transformer.transformToDao(client);

		log.info(":: transform from client DAO object to client object ::  Transf  {} " , clientDao);
		
		clientDao = repo.save(clientDao);
		
		log.info(":: Update   Client  SERVICE ::  DB INFO {} " , clientDao);

		return transformer.transformToClient(clientDao);
	}

	@Override
	public Users getClientById(Long id) {
		
		H2ClientDao h2ClientDao = repo.getOne(id);
		log.info(":: Transform from client DAO to client object ::  DB INFO {} " , h2ClientDao);
		
		return transformer.transformToClient(h2ClientDao);
	}

	public void deleteClientById(Long id) {
			repo.deleteById(id);
	}

}
