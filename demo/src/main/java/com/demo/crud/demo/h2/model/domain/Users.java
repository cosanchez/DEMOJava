package com.demo.crud.demo.h2.model.domain;

import lombok.Data;

@Data
public class Users {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String type;

}
