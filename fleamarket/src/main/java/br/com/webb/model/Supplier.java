package br.com.webb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import br.com.webb.model.common.Address;

@Document
public class Supplier extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private String name;

	private Address address;
	
	public Supplier() {}
	
	public Supplier(String name, Address address) {
		
		if(name == null || address == null)
			throw new IllegalArgumentException("Can't create object in an invalid state!");
		
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isValid() {
		return isNotBlank(name) && address != null && address.isValid();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
