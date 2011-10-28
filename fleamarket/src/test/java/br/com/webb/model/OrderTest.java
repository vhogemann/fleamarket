package br.com.webb.model;

import static br.com.webb.model.Util.validQuote;
import static br.com.webb.model.Util.validRequest;

import org.junit.Test;

public class OrderTest {

	@Test
	public void constructorTest(){
		new Order(validQuote(validRequest()));
	}
	
}
