package br.com.webb.model;

import org.springframework.data.mongodb.core.mapping.Document;

import br.com.webb.model.common.Address;

@Document
public class User extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	private String firstName;
	
	private String lastName;
	
	private Address address;
	
}
