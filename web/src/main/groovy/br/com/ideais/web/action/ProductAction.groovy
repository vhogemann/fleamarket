package br.com.ideais.web.action

import org.springframework.beans.factory.annotation.Autowire
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ideais.model.Product
import br.com.ideais.repository.ProductRepository
import br.com.ideais.web.action.AbstractEntityAction;

class ProductAction extends AbstractEntityAction<Product> {
	
	String requestId

	@Autowired
	ProductRepository repository
	
	Product getEntity(){
		super.entity
	}
	
	void setEntity( Product p ){
		super.entity = p	
	}
	
	Product newEntity(){
		new Product()
	}
	
	public MongoRepository<Product, String> getRepository(){ return repository }
	
}
