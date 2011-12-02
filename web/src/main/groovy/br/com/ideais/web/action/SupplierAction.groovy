package br.com.ideais.web.action

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ideais.model.AbstractEntity;
import br.com.ideais.model.Request;
import br.com.ideais.model.Supplier;
import br.com.ideais.model.common.AddressType;
import br.com.ideais.repository.SupplierRepository;

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
