package com.demo.crud.demo;

import com.demo.crud.demo.h2.model.dao.H2ClientDao;
import com.demo.crud.demo.h2.model.domain.Users;

public class Dummies {
	public static H2ClientDao getClientDao() {
		H2ClientDao h2ClientDao = new H2ClientDao();
		h2ClientDao.setId(1);
		h2ClientDao.setFirstName("Carlos");
		h2ClientDao.setLastName("Sanchez");
		h2ClientDao.setType("Man");

		return h2ClientDao;
	}
	
	public static Users getClient() {
		Users client = new Users();
		client.setId(1);
		client.setFirstName("Carlos");
		client.setLastName("Sanchez");
		client.setType("Man");

		return client;
	}
}
