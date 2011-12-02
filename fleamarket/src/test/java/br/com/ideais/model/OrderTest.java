package br.com.ideais.model;

import static br.com.ideais.model.Util.validQuote;
import static br.com.ideais.model.Util.validRequest;

import org.junit.Test;

import br.com.ideais.model.Order;

public class OrderTest {

	@Test
	public void constructorTest(){
		new Order(validQuote(validRequest()));
	}
	
}
