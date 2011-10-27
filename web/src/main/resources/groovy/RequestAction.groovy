package br.com.webb.web.action

import org.springframework.beans.factory.annotation.Autowire
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.webb.model.Product
import br.com.webb.model.Request;
import br.com.webb.repository.ProductRepository
import br.com.webb.web.action.AbstractEntityAction;

class RequestAction extends AbstractEntityAction<Request> {

	
	Product getEntity(){
		super.entity
	}
	
	void setEntity( Request p ){
		super.entity = p
	}
	
	Request newEntity(){
		new Request()
	}
	
}
