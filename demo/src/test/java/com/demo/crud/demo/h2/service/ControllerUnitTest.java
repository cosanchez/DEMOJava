package com.demo.crud.demo.h2.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.crud.demo.Dummies;
import com.demo.crud.demo.h2.controller.Controller;
import com.demo.crud.demo.h2.model.domain.Users;

@RunWith(SpringRunner.class)
public class ControllerUnitTest extends AbstractJUnit4SpringContextTests {
	@Mock
	private Service service;

	@InjectMocks
	private Controller controller;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getClientsEmpty() {
		when(service.getClients()).thenReturn(new ArrayList<Users>());
		List<Users> list = controller.getAllClients();
		Assert.assertEquals(list.isEmpty(), true);
	}

	@Test
	public void createClient() {
		when(service.createClient(Dummies.getClient())).thenReturn(Dummies.getClient());
		Users client = controller.createClient(Dummies.getClient());
		Assert.assertNotNull(client);
	}

	@Test
	public void updateClient() {
		when(service.updateClient(Dummies.getClient())).thenReturn(Dummies.getClient());
		Users client = controller.updateClient(Dummies.getClient());
		Assert.assertNotNull(client);
	}

	@Test
	public void deleteClient() {
		doNothing().when(service).deleteClientById(2L);
		;
		controller.deleteClientById(2L);
	}
}
