package br.com.webb.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product extends AbstractEntity{

	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	
	public Product() {}
	
	public Product(String name, String description) {
		if( name == null || description == null)
			throw new IllegalArgumentException("Can't create object in a invalid state");
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
