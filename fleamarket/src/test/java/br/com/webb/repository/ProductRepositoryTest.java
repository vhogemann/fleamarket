package br.com.webb.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.webb.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:test-context.xml")
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;
	
	
	@Test
	public void testCreate(){
		
		Product product = new Product("testProduct","Produto de Teste");
		productRepository.save(product);
		
	}
	
	@Test
	public void testFind(){
		
		List<Product> prods = productRepository.findAll();
		
		if(prods != null) for(Product product : prods){
			System.out.println(product.getId());
		}
			
	}
	
}
