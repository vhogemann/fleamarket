package br.com.webb.service;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.webb.model.Request;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:test-context.xml")
public class RequestServiceTest {

	@Autowired
	private RequestService service;
	
	@Test
	public void testPlaceRequest(){
		Request in = new Request();
		try{
			service.placeRequest(in);
			Assert.fail("Deixou criar request inválido");
		} catch(IllegalArgumentException e){}
		
		
	}
	
	@Test
	public void testPlaceQuote(){
		
	}
	
	@Test
	public void testList(){
		
	}
	
}
