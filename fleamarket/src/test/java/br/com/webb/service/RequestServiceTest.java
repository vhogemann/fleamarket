package br.com.webb.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:test-context.xml")
public class RequestServiceTest {

	@Autowired
	private RequestService service;
	
	public void testPlaceRequest(){
		
	}
	
}
