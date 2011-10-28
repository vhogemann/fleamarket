package br.com.webb.model.order;

import java.util.Arrays;
import java.util.List;

public enum RequestState {
	
	CLOSED(),
	ORDERED(CLOSED),
	PENDING_ORDERS(ORDERED,CLOSED),
	PENDING_QUOTES(PENDING_ORDERS,CLOSED),
	DENIED(),
	WAITING_FOR_APPROVAL( PENDING_QUOTES, DENIED, CLOSED ),
	DRAFT( WAITING_FOR_APPROVAL, CLOSED );
	
	private List<RequestState> valid;
	
	private RequestState(RequestState ... valid ) {
		this.valid = Arrays.asList(valid);
	}
	
	public boolean canChangeTo(RequestState status){
		return valid.contains(status);
	}
	
}
