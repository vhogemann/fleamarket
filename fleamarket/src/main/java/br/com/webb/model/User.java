package br.com.webb.model;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.data.mongodb.core.mapping.Document;

import br.com.webb.model.common.Address;

@Document
public class User extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String firstName;

	private String lastName;

	private String username;

	private String digestMD5;

	private Address address;

	public User() {
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.digestMD5 = digest(password);
	}

	private String digest(String password) {
		String digest = null;
		try{
		byte[] bytes = MessageDigest.getInstance("MD5").digest(password.getBytes("UTF-8"));
		digest = new BigInteger(1, bytes).toString(16);
		} catch( NoSuchAlgorithmException e ){
		} catch (UnsupportedEncodingException e) {
		}
		return digest;
	}

	public boolean validate(String password) {
		return this.digestMD5.equals(digest(password));
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDigestMD5() {
		return digestMD5;
	}

	public void setDigestMD5(String digestMD5) {
		this.digestMD5 = digestMD5;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
