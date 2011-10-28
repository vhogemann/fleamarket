package br.com.webb.service;

import br.com.webb.model.Order;


public interface RequestService {
	
	public void publish(String id, String reason);
	
	public void approve(String id, String reason);
	
	public void cancel(String id, String reason);
	
	public void endQuoting(String id, String reason);
	
	public Order approveBestQuote(String requestId);
	
	public Order approveQuote(String requestId, String quoteId);

}
