package br.com.webb.web.action

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository

import br.com.webb.model.Request
import br.com.webb.model.common.AddressType
import br.com.webb.repository.RequestRepository

class RequestAction extends AbstractEntityAction<Request> {

	@Autowired
	RequestRepository repository;
	
	Request getEntity(){
		super.entity
	}
	
	void setEntity( Request p ){
		super.entity = p
	}
	
	Request newEntity(){
		new Request()
	}
	
	def getAddressTypes(){
		return AddressType.values();
	}
	
	public MongoRepository<Request, String> getRepository(){ return repository }
}
