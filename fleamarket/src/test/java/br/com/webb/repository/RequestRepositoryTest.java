package br.com.webb.repository;

import java.math.BigDecimal;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.webb.model.Product;
import br.com.webb.model.Request;
import br.com.webb.model.common.Address;
import br.com.webb.model.common.AddressType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:test-context.xml")
public class RequestRepositoryTest extends AbstractMongoRepositoryTest<Request> {

	@Autowired
	RequestRepository repository;
	
	@Autowired
	ProductRepository productRepository;
	
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
