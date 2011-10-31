package br.com.webb.web.action

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.repository.MongoRepository

import br.com.webb.model.Product
import br.com.webb.model.Request
import br.com.webb.model.common.AddressType
import br.com.webb.repository.ProductRepository
import br.com.webb.repository.RequestRepository

class RequestAction extends AbstractEntityAction<Request> {

	@Autowired
	RequestRepository repository
	
	@Autowired
	ProductRepository prodRepo
	
	String prodId
	int quantity = 1
	
	def add(){
		if(!prodId)
			return super.FAILURE
		Product prod = prodRepo.findOne(prodId)
		
		Request request = getEntity()
		request.addProduct(prod, quantity)
		repository.save(request)
		
		return super.SUCCESS
	}
	
	def products(){
		return super.SUCCESS
	}
	
	public Request getEntity(){
		return super.entity
	}
	
	void setEntity( Request p ){
		super.entity = p
	}
	
	Request newEntity(){
		return new Request()
	}
	
	def getAddressTypes(){
		return AddressType.values();
	}
	
	public MongoRepository<Request, String> getRepository(){ return repository }
}
