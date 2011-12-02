package br.com.ideais.model.order;

import java.util.Arrays;
import java.util.List;

public enum RequestState {
	CANCELED(),
	ORDERED(),
	PENDING_ORDER(ORDERED),
	PENDING_QUOTES(PENDING_ORDER,CANCELED),
	PENDING_APPROVAL( PENDING_QUOTES, CANCELED),
	DRAFT( PENDING_APPROVAL, CANCELED );
	
	private List<RequestState> valid;
	
	private RequestState(RequestState ... valid ) {
		this.valid = Arrays.asList(valid);
	}
	
	public boolean canChangeTo(RequestState status){
		return valid.contains(status);
	}
	
	public List<RequestState> getValid(){
		return valid;
	}
}
