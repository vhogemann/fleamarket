package br.com.webb.model;

import br.com.webb.model.common.Address;

public class Supplier extends AbstractEntity {
	
	
	private static final long serialVersionUID = 1L;

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
		// TODO Auto-generated method stub
		return false;
	}
	
}
