package br.com.webb.web.action

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.webb.model.AbstractEntity;
import br.com.webb.model.Request;
import br.com.webb.model.Supplier;
import br.com.webb.model.common.AddressType;
import br.com.webb.repository.SupplierRepository;

class SupplierAction extends AbstractEntityAction<Supplier> {

	@Autowired
	SupplierRepository repository
	
	def addressTypes = AddressType.values()
	
	Supplier newEntity() {
		return new Supplier()
	}
	
	public MongoRepository<Supplier,String> getRepository() {
		return repository
	}
	
	Supplier getEntity(){
		return super.entity
	}
	
	void setEntity( Supplier p ){
		super.entity = p
	}

}
