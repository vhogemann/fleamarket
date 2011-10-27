package br.com.webb.model;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.Test;

import br.com.webb.model.common.Address;
import br.com.webb.model.common.AddressType;
import br.com.webb.model.order.RequestState;
import br.com.webb.model.order.RequestStatus;

public class RequestTest {

	private Request validRequest(){
		Address address = new Address("Rua da Assembleia", "98", null, "20011-000", "Brasil", "RJ", "Rio de Janeiro", AddressType.COMMERCIAL);
		Request request = new Request(address,"Teste Unitário");
		request.addProduct(new Product("prod1", "desc", new BigDecimal(10.0)), 1);
		request.addProduct(new Product("prod2", "desc", new BigDecimal(5.0)), 2);
		request.addProduct(new Product("prod3", "desc", new BigDecimal(20.0)), 1);
		return request;
	}
	
	@Test
	public void constructorTest(){
		
		Request request = validRequest();
		
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
		
		Request request = validRequest();
		
		request.setStatus(new RequestStatus(RequestState.WAITING_FOR_APPROVAL,"aguardando aprovação"));
		
		request.setStatus(new RequestStatus(RequestState.PENDING_QUOTES, "aguarndando cotações"));
		
		request.setStatus(new RequestStatus(RequestState.PENDING_ORDERS, "aguardando pedidos"));
		
		request.setStatus(new RequestStatus(RequestState.CLOSED, "fechado"));
	}
	
	@Test
	public void addProductTest(){
		
		Product product = new Product("Test", "Description", new BigDecimal(10.0));
		
		Request request = validRequest();
		
		request.addProduct(product, 10);
		
		try{
			product = new Product();
			request.addProduct(product, 10);
			Assert.fail("Add an invalid product should not be possible");
		} catch (IllegalArgumentException e) {/* OK */}
		
		request.setStatus(new RequestStatus(RequestState.WAITING_FOR_APPROVAL, "Can't add new products from now on"));
		
		try{
			product = new Product("Test2", "Description", new BigDecimal(10.0));
			request.addProduct(product, 11);
			Assert.fail("Only requests on the DRAFT state can accept new products");
		} catch(IllegalStateException e){ /* OK */}
	}
	
	@Test
	public void addQuoteTest(){
		
		Request request = validRequest();
		
		Quote quote = new Quote(
				new Supplier("Supplier",
						new Address(
								"Rua da Assembleia", "98", null,
								"20011-000", "Brasil", "RJ",
								"Rio de Janeiro", AddressType.COMMERCIAL)), 
							request); 
		
		try{
			request.addQuote(quote);
			Assert.fail("Must change to WAITING_QUOTES first");
		} catch (IllegalStateException e){/* OK */}
		
		request.setStatus(new RequestStatus(RequestState.WAITING_FOR_APPROVAL,""));
		request.setStatus(new RequestStatus(RequestState.PENDING_QUOTES,""));
		
		request.addQuote(quote);
		
		quote = new Quote(
				new Supplier("Supplier",
						new Address(
								"Rua da Assembleia", "98", null,
								"20011-000", "Brasil", "RJ",
								"Rio de Janeiro", AddressType.COMMERCIAL)), 
							request); 
		try{
			quote.setItems(null);
			request.addQuote(quote);
			Assert.fail("Quote must match every Request Item");
		}catch(IllegalArgumentException e){/* OK */}
	}
	
	@Test
	public void setOrderTest(){
		
		Request request = validRequest();
		
		Quote quote = new Quote(
				new Supplier("Supplier",
						new Address(
								"Rua da Assembleia", "98", null,
								"20011-000", "Brasil", "RJ",
								"Rio de Janeiro", AddressType.COMMERCIAL)), 
							request); 
		
		request.setStatus(new RequestStatus(RequestState.WAITING_FOR_APPROVAL,""));
		request.setStatus(new RequestStatus(RequestState.PENDING_QUOTES,""));
		
		request.addQuote(quote);
		
		request.setStatus(new RequestStatus(RequestState.PENDING_ORDERS, "aguardando pedidos"));
		
		request.setOrder(new Order(quote));
		
	}
	
	@Test
	public void invalidStatusChangeTest(){
		Address address = new Address("Rua da Assembleia", "98", null, "20011-000", "Brasil", "RJ", "Rio de Janeiro", AddressType.COMMERCIAL);
		Request request = new Request(address,"Teste Unitário");
		
		try{
			request.setStatus(new RequestStatus(RequestState.DENIED, "meh"));
			Assert.fail("Illegal status");			
		} catch (IllegalArgumentException e){
			//OK
		}
		
	}
	
}
