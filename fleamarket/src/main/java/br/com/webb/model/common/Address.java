package br.com.webb.model.common;

public class Address {

	private String streetName;
	private String number;
	private String complement;
	
	private String postalCode;
	private String country;
	private String state;
	private String city;
	
	private AddressType type;

	
	
	
	public Address(String streetName, String number, String complement,
			String postalCode, String country, String state, String city,
			AddressType type) {
		super();
		this.streetName = streetName;
		this.number = number;
		this.complement = complement;
		this.postalCode = postalCode;
		this.country = country;
		this.state = state;
		this.city = city;
		this.type = type;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public AddressType getType() {
		return type;
	}

	public void setType(AddressType type) {
		this.type = type;
	}
	
}