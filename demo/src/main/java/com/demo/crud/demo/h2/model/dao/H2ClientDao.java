package com.demo.crud.demo.h2.model.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

	@JsonSerialize
	@Data
	@Entity
	@Table(name="USERS")
	public class H2ClientDao implements Serializable {

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotNull
		@Column(name="FIRSTNAME")
		private String firstName;
		
		@NotNull
		@Column(name="LASTNAME")
		private String lastName;
		
		@NotNull
		@Column(name="EMAIL")
		private String email;
		
		@Column(name="TYPE")
		private String type;

	}

