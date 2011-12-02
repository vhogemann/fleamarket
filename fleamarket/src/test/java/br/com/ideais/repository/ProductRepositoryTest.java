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
import br.com.ideais.repository.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:test-context.xml")
public class ProductRepositoryTest extends AbstractMongoRepositoryTest<Product> {

	
	@Autowired
	private ProductRepository repository;

	@Test
	public void findByNameTest(){
		
		repository.save(newEntity());
		
		List<Product> list = repository.findByName("name");
		
		Assert.notEmpty(list);
	}
	
	@Test
	public void findByNameLike(){
		
		repository.save(newEntity());
		
		List<Product> list = repository.findByNameLike("na.*");
		
		Assert.notEmpty(list);
	}
	
	@Override
	public Product newEntity() {
		return new Product("name","description",new BigDecimal(1.0));
	}

	@Override
	public MongoRepository<Product, String> getRepository() {
		return repository;
	}

	@Override
	public void afterResetHook(){}
	
}
