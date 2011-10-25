package br.com.webb.service;

import java.util.List;

import br.com.webb.model.Quote;
import br.com.webb.model.Request;
import br.com.webb.model.item.RequestItem;
import br.com.webb.model.order.RequestStatus;

public interface RequestService {
	
	public Request placeRequest(List<RequestItem> items, String description);
	
	public Request placeQuote(Request request, Quote quote);
	
	public List<Request> listRequests(RequestStatus status, int offser, int limit);

}
