package br.com.webb.model.order;

import java.util.Arrays;
import java.util.List;

public enum RequestStatus {
	
	CLOSED(),
	ORDERED(CLOSED),
	PENDING_ORDERS(ORDERED,CLOSED),
	PENDING_QUOTES(PENDING_ORDERS,CLOSED),
	DENIED(),
	APPROVED(PENDING_QUOTES, CLOSED),
	WAITING_FOR_APPROVAL( APPROVED, DENIED, CLOSED ),
	DRAFT( WAITING_FOR_APPROVAL, CLOSED );
	
	private List<RequestStatus> valid;
	
	private RequestStatus(RequestStatus ... valid ) {
		this.valid = Arrays.asList(valid);
	}
	
	public boolean canChangeTo(RequestStatus status){
		return valid.contains(status);
	}
	
}
