package com.demo.crud.demo.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.crud.demo.h2.model.dao.H2ClientDao;

@org.springframework.stereotype.Repository
public interface Repository extends  JpaRepository<H2ClientDao, Long>{



}
