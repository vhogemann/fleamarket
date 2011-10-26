package br.com.webb.service;

import java.util.List;

import br.com.webb.model.Request;
import br.com.webb.model.order.RequestStatus;

public interface RequestService {
	
	public Request placeRequest(Request request);
	
	public List<Request> list(RequestStatus status, int offser, int limit);

}
