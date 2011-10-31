package br.com.webb.web.action

import org.springframework.beans.factory.annotation.Autowire
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.webb.model.Product
import br.com.webb.repository.ProductRepository
import br.com.webb.web.action.AbstractEntityAction;

class ProductAction extends AbstractEntityAction<Product> {

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
