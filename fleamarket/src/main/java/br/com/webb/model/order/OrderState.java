package br.com.webb.model.order;

import java.util.Arrays;
import java.util.List;

public enum OrderState {
	
	CANCELED,
	RETURNED,
	MISSCARRIED,
	RECEIVED(RETURNED),
	SUBMITED(RECEIVED,MISSCARRIED),
	WAITING_FOR_SUPPLIER(SUBMITED,CANCELED),
	WAITING_PAYMENT(SUBMITED,WAITING_FOR_SUPPLIER,CANCELED),
	NEW(WAITING_PAYMENT,CANCELED);
	
	private List<OrderState> valid;
	
	private OrderState(OrderState ... valid) {
		this.valid = Arrays.asList(valid);
	}
	
	public boolean canChangeTo(OrderState status){
		return valid.contains(status);
	}

}
