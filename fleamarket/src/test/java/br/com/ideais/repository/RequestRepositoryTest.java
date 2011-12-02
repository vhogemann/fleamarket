package br.com.ideais.repository;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import br.com.ideais.model.Product;
import br.com.ideais.model.Request;
import br.com.ideais.model.common.Address;
import br.com.ideais.model.common.AddressType;
import br.com.ideais.model.order.RequestState;
import br.com.ideais.repository.ProductRepository;
import br.com.ideais.repository.RequestRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:test-context.xml")
public class RequestRepositoryTest extends AbstractMongoRepositoryTest<Request> {

	@Autowired
	RequestRepository repository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Test
	public void findByStatusStateTest(){
		
		Request request = newEntity();

		repository.save(request);
		
		List<Request> list = repository.findByStatusState(RequestState.DRAFT);
		
		Assert.notEmpty(list);
		
	}
	
	@Override
	public Request newEntity() {
		Address address = new Address("Rua da Assembleia", "98", null, "20011-000", "Brasil", "RJ", "Rio de Janeiro", AddressType.COMMERCIAL);
		Request request = new Request(address,"Teste Unitário");
		
		Product product = productRepository.save(new Product("prod1", "desc", new BigDecimal(10.0)));
		request.addProduct(product, 1);
		
		product = productRepository.save(new Product("prod2", "desc", new BigDecimal(5.0)));
		request.addProduct(product, 2);
		
		product = productRepository.save(new Product("prod3", "desc", new BigDecimal(20.0)));
		request.addProduct(product, 1);
		
		return request;
	}

	@Override
	public MongoRepository<Request, String> getRepository() {
		return repository;
	}

	@Override
	public void afterResetHook() {
		productRepository.deleteAll();
	}
	
}
