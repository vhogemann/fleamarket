package br.com.webb.web.action

import org.springframework.beans.factory.annotation.Autowire
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.webb.model.Product
import br.com.webb.repository.ProductRepository
import br.com.webb.web.action.AbstractEntityAction;

class ProductAction extends AbstractEntityAction<Product> {

	Product newEntity(){
		new Product()
	}
	
}
