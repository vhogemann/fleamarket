package br.com.webb.model;

import junit.framework.Assert;

import org.junit.Test;

import br.com.webb.model.common.Address;
import br.com.webb.model.common.AddressType;
import br.com.webb.model.order.RequestHistoryItem;
import br.com.webb.model.order.RequestStatus;

public class RequestTest {

	@Test
	public void constructorTest(){
		
		Address address = new Address("Rua da Assembleia", "98", null, "20011-000", "Brasil", "RJ", "Rio de Janeiro", AddressType.COMMERCIAL);
		Request request = new Request(address,"Teste Unitário");
		
		Assert.assertTrue(request.isValid());
		
		request = new Request();
		
		Assert.assertFalse(request.isValid());
		
		try{
			
			request = new Request(null, null);
			Assert.fail("Should have trhown IllegalStateException");
		
		}catch (IllegalStateException e) {
			//OK
		}
		
	}
	
	@Test
	public void statusChangeTest(){
		
		Address address = new Address("Rua da Assembleia", "98", null, "20011-000", "Brasil", "RJ", "Rio de Janeiro", AddressType.COMMERCIAL);
		Request request = new Request(address,"Teste Unitário");
		
		request.setStatus(new RequestHistoryItem(RequestStatus.WAITING_FOR_APPROVAL,"aguardando aprovação"));
		
		request.setStatus(new RequestHistoryItem(RequestStatus.APPROVED, "aprovado"));
		
		request.setStatus(new RequestHistoryItem(RequestStatus.PENDING_QUOTES, "aguarndando cotações"));
		
		request.setStatus(new RequestHistoryItem(RequestStatus.PENDING_ORDERS, "aguardando pedidos"));
		
		request.setStatus(new RequestHistoryItem(RequestStatus.CLOSED, "fechado"));
	}
	
	@Test
	public void invalidStatusChangeTest(){
		Address address = new Address("Rua da Assembleia", "98", null, "20011-000", "Brasil", "RJ", "Rio de Janeiro", AddressType.COMMERCIAL);
		Request request = new Request(address,"Teste Unitário");
		
		try{
			request.setStatus(new RequestHistoryItem(RequestStatus.DENIED, "meh"));
			Assert.fail("Illegal status");			
		} catch (IllegalArgumentException e){
			//OK
		}
		
	}
	
}
