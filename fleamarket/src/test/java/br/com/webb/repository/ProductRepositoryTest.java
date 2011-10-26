package br.com.webb.repository;

import java.math.BigDecimal;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.webb.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:test-context.xml")
public class ProductRepositoryTest extends AbstractMongoRepositoryTest<Product> {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product newEntity() {
		return new Product("name","description",new BigDecimal(1.0));
	}

	@Override
	public MongoRepository<Product, String> getRepository() {
		return productRepository;
	}
	
}
