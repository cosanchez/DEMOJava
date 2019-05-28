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
import com.demo.crud.demo.h2.mapper.Transformer;
import com.demo.crud.demo.h2.model.dao.H2ClientDao;
import com.demo.crud.demo.h2.model.domain.Users;
import com.demo.crud.demo.h2.repository.Repository;

@RunWith(SpringRunner.class)
public class ServiceUnitTest extends AbstractJUnit4SpringContextTests {
	@Mock
	private Repository repo;

	@Mock
	private Transformer transformer;

	@InjectMocks
	private ServiceImpl service;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getClientsEmpty() {
		when(repo.findAll()).thenReturn(new ArrayList<H2ClientDao>());
		List<Users> list = service.getClients();

		Assert.assertEquals(list.isEmpty(), true);
	}

	@Test
	public void getClientByIdOK() {
		when(repo.getOne(2L)).thenReturn(Dummies.getClientDao());
		when(transformer.transformToClient(Dummies.getClientDao())).thenReturn(Dummies.getClient());
		Users client = service.getClientById(2L);
		Assert.assertNotNull(client);
		Assert.assertEquals("Carlos", client.getFirstName());
	}

	@Test
	public void createClient() {
		when(transformer.transformToDao(Dummies.getClient())).thenReturn(Dummies.getClientDao());
		when(repo.save(Dummies.getClientDao())).thenReturn(Dummies.getClientDao());
		when(transformer.transformToClient(Dummies.getClientDao())).thenReturn(Dummies.getClient());
		Users client = service.createClient(Dummies.getClient());
		Assert.assertNotNull(client);

	}

	@Test
	public void updateClient() {
		when(transformer.transformToDao(Dummies.getClient())).thenReturn(Dummies.getClientDao());
		when(repo.save(Dummies.getClientDao())).thenReturn(Dummies.getClientDao());
		when(transformer.transformToClient(Dummies.getClientDao())).thenReturn(Dummies.getClient());
		Users client = service.updateClient(Dummies.getClient());
		Assert.assertNotNull(client);

	}
	

	@Test
	public void deleteClient() {
		doNothing().when(repo).deleteById(2L);
		service.deleteClientById(2L);
	}

}
