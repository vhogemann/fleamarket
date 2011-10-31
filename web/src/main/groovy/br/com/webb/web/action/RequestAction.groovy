package br.com.webb.web.action

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.repository.MongoRepository

import br.com.webb.model.Product
import br.com.webb.model.Quote
import br.com.webb.model.Request
import br.com.webb.model.common.AddressType
import br.com.webb.repository.ProductRepository
import br.com.webb.repository.RequestRepository
import br.com.webb.repository.SupplierRepository

class RequestAction extends AbstractEntityAction<Request> {

	@Autowired
	RequestRepository repository
	
	@Autowired
	ProductRepository productRepository
	
	@Autowired
	SupplierRepository supplierRepository
	
	String prodId
	int quantity = 1
	
	def suppliers
	
	def addressTypes = AddressType.values()
	
	Quote quote
	
	def newQuote(){
		quote = new Quote(null, getEntity());
		suppliers = supplierRepository.findAll();
		return SUCCESS	
	}
	
	def quote(){
		Request request = getEntity();
		request.addQuote(quote);
		repository.save(request);
		return SUCCESS
	}
	
	def add(){
		if(!prodId)
			return super.FAILURE
		Product prod = productRepository.findOne(prodId)
		
		Request request = getEntity()
		request.addProduct(prod, quantity)
		repository.save(request)
		
		return SUCCESS
	}
	
	def products(){
		return SUCCESS
	}
	
	Request getEntity(){
		return super.entity
	}
	
	def setEntity( Request p ){
		super.entity = p
	}
	
	Request newEntity(){
		return new Request()
	}
	
	public MongoRepository<Request, String> getRepository(){ return repository }
}
