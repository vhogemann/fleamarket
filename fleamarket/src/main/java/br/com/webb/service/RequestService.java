package br.com.webb.service;

import java.util.List;

import br.com.webb.model.Quote;
import br.com.webb.model.Request;
import br.com.webb.model.User;
import br.com.webb.model.item.RequestItem;
import br.com.webb.model.order.RequestStatus;

public interface RequestService {
	
	public Request placeRequest(List<RequestItem> items, String description, User requisitant);
	
	public Request cancelRequest(Request request, User user);
	
	public Request approveRequest(Request request, User user);
	
	public Request placeQuote(Request request, Quote quote, User user);
	
	public List<Request> listRequests(User user, RequestStatus status, int offser, int limit);

}
