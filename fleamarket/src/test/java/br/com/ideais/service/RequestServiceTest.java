package br.com.ideais.service;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ideais.model.Order;
import br.com.ideais.model.Product;
import br.com.ideais.model.Quote;
import br.com.ideais.model.Request;
import br.com.ideais.model.Supplier;
import br.com.ideais.model.common.Address;
import br.com.ideais.model.common.AddressType;
import br.com.ideais.model.item.Item;
import br.com.ideais.model.order.RequestState;
import br.com.ideais.repository.ProductRepository;
import br.com.ideais.repository.RequestRepository;
import br.com.ideais.repository.SupplierRepository;
import br.com.ideais.service.RequestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:test-context.xml")
public class RequestServiceTest {

	@Autowired
	private RequestService service;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private RequestRepository requestRepository;
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Test
	public void publishTest(){
		Request request = newEntity();
		service.publish(request.getId(), "test");
		
		request = requestRepository.findOne(request.getId());
		
		Assert.assertEquals(RequestState.PENDING_APPROVAL, request.getStatus().getState());
	}
	
	@Test
	public void approveTest(){
		Request request = newEntity();
		
		try{
			service.approve(request.getId(), "test");
			Assert.fail();
		} catch(IllegalArgumentException e){/* OK */}
		
		service.publish(request.getId(), "test");
		service.approve(request.getId(), "test");
		
		request = requestRepository.findOne(request.getId());
		
		Assert.assertEquals(RequestState.PENDING_QUOTES, request.getStatus().getState());
	}
	
	@Test
	public void cancelTest(){
		Request request = newEntity();
		
		service.publish(request.getId(), "test");
		service.cancel(request.getId(), "test");
		
		request = requestRepository.findOne(request.getId());
		
		Assert.assertEquals(RequestState.CANCELED, request.getStatus().getState());
	}
	
	@Test
	public void endQuotingTest(){
		Request request = newEntity();
		
		service.publish(request.getId(), "test");
		service.approve(request.getId(), "test");
		service.endQuoting(request.getId(), "test");
		
		request = requestRepository.findOne(request.getId());
		
		Assert.assertEquals(RequestState.PENDING_ORDER, request.getStatus().getState());
	}
	
	@Test
	public void approveBestQuoteTest(){
		Request request = newEntity();
		service.publish(request.getId(), "test");
		service.approve(request.getId(), "test");
		request = requestRepository.findOne(request.getId());
		
		Supplier supplier = newSupplier();
		
		Quote best = new Quote( supplier , request );
		for(Item item : best.getItems()){
			item.setPrice(new BigDecimal(1.0));
		}
		request.addQuote(best);
		
		Quote worst = new Quote( supplier , request );
		request.addQuote(worst);
		
		requestRepository.save(request);
		
		service.endQuoting(request.getId(), "test");
		
		Order actual = service.approveBestQuote(request.getId());
		
		Assert.assertEquals(actual.getQuote().getId(), best.getId());
	}
	
	@Test
	public void approveQuoteTest(){
		Request request = newEntity();
		service.publish(request.getId(), "test");
		service.approve(request.getId(), "test");
		request = requestRepository.findOne(request.getId());
		
		Supplier supplier = newSupplier();
		
		Quote best = new Quote( supplier , request );
		for(Item item : best.getItems()){
			item.setPrice(new BigDecimal(1.0));
		}
		request.addQuote(best);
		
		Quote worst = new Quote( supplier , request );
		request.addQuote(worst);
		
		requestRepository.save(request);
		
		service.endQuoting(request.getId(), "test");
		
		Order actual = service.approveQuote(request.getId(), worst.getObjectId());
		
		Assert.assertEquals(actual.getQuote().getId(), worst.getId());
	}
	
	@After
	public void cleanRepositories(){
		supplierRepository.deleteAll();
		productRepository.deleteAll();
		requestRepository.deleteAll();
	}
	
	public Supplier newSupplier(){
		Address address = new Address("Rua da Assembleia", "98", null, "20011-000", "Brasil", "RJ", "Rio de Janeiro", AddressType.COMMERCIAL);
		
		Supplier supplier = new Supplier("Ideais Tecnologia", address);
		
		return supplierRepository.save(supplier);
	}
	
	public Request newEntity() {
		Address address = new Address("Rua da Assembleia", "98", null, "20011-000", "Brasil", "RJ", "Rio de Janeiro", AddressType.COMMERCIAL);
		Request request = new Request(address,"Teste Unitário");
		
		Product product = productRepository.save(new Product("prod1", "desc", new BigDecimal(10.0)));
		
		request.addProduct(product, 1);
		
		requestRepository.save(request);
		
		return request;
	}
	
	
}
