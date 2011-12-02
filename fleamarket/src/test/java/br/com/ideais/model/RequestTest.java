package br.com.ideais.model;

import java.math.BigDecimal;

import static br.com.ideais.model.Util.*;

import junit.framework.Assert;

import org.junit.Test;

import br.com.ideais.model.Order;
import br.com.ideais.model.Product;
import br.com.ideais.model.Quote;
import br.com.ideais.model.Request;
import br.com.ideais.model.Supplier;
import br.com.ideais.model.common.Address;
import br.com.ideais.model.common.AddressType;
import br.com.ideais.model.order.RequestState;
import br.com.ideais.model.order.RequestStatus;

public class RequestTest {

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
		
		request.setStatus(new RequestStatus(RequestState.PENDING_APPROVAL,"aguardando aprovação"));
		
		request.setStatus(new RequestStatus(RequestState.PENDING_QUOTES, "aguarndando cotações"));
		
		request.setStatus(new RequestStatus(RequestState.PENDING_ORDER, "aguardando pedidos"));
		
		request.setStatus(new RequestStatus(RequestState.ORDERED, "pedido feito"));
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
		
		request.setStatus(new RequestStatus(RequestState.PENDING_APPROVAL, "Can't add new products from now on"));
		
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
		
		request.setStatus(new RequestStatus(RequestState.PENDING_APPROVAL,""));
		request.setStatus(new RequestStatus(RequestState.PENDING_QUOTES,""));
		
		request.addQuote(quote);
		
		quote = new Quote(
				new Supplier("Supplier",
						new Address(
								"Rua da Assembleia", "98", null,
								"20011-000", "Brasil", "RJ",
								"Rio de Janeiro", AddressType.COMMERCIAL)), 
							request); 
	}
	
	@Test
	public void setOrderTest(){
		
		Request request = validRequest();
		Quote quote = validQuote(request);
		
		request.setStatus(new RequestStatus(RequestState.PENDING_APPROVAL,""));
		request.setStatus(new RequestStatus(RequestState.PENDING_QUOTES,""));
		
		request.addQuote(quote);
		
		request.setStatus(new RequestStatus(RequestState.PENDING_ORDER, "aguardando pedidos"));
		
		request.setOrder(new Order(quote));
		
	}
	
	@Test
	public void invalidStatusChangeTest(){
		Address address = new Address("Rua da Assembleia", "98", null, "20011-000", "Brasil", "RJ", "Rio de Janeiro", AddressType.COMMERCIAL);
		Request request = new Request(address,"Teste Unitário");
		
		try{
			request.setStatus(new RequestStatus(RequestState.PENDING_ORDER, "meh"));
			Assert.fail("Illegal status");			
		} catch (IllegalArgumentException e){
			//OK
		}
		
	}
	
}
