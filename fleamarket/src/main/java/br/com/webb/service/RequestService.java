package br.com.webb.service;

import java.util.List;

import br.com.webb.model.Request;
import br.com.webb.model.order.RequestState;

public interface RequestService {
	
	public Request placeRequest(Request request);
	
	public List<Request> listAll();
	
	public List<Request> list(RequestState status, int offser, int limit);

}
