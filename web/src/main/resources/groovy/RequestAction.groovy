package br.com.webb.web.action

import br.com.webb.model.Request
import br.com.webb.model.common.AddressType
import br.com.webb.service.RequestService
import br.com.webb.web.action.AbstractEntityAction

class RequestAction extends AbstractEntityAction<Request> {

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
	
}
