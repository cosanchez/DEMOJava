package com.demo.crud.demo.h2.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.crud.demo.h2.model.dao.H2ClientDao;
import com.demo.crud.demo.h2.model.domain.Users;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class Transformer  extends ConfigurableMapper{
	private MapperFacade mapper;
	
	@Autowired
	public MapperFactory settingMapper(MapperFactory factory) {
		mapper=factory.getMapperFacade();
	    factory.classMap(H2ClientDao.class,  Users.class).byDefault().register();
	    factory.classMap(Users.class,  H2ClientDao.class).byDefault().register();
		return factory;
	}
	
	
	public H2ClientDao transformToDao(Users client) {
		return mapper.map(client,H2ClientDao.class);
	}
	
	public Users transformToClient(H2ClientDao h2ClientDao) {
		return mapper.map(h2ClientDao,Users.class);
	}
	
	public List<Users> transformToClientList(List<H2ClientDao> h2ClientDao) {
		return mapper.mapAsList(h2ClientDao, Users.class);
	}
	
	
	
	
}
