package br.com.webb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webb.model.Quote;
import br.com.webb.model.Request;
import br.com.webb.model.order.RequestState;
import br.com.webb.repository.RequestRepository;

@Service
public class RequestServiceImpl implements RequestService {
	
	@Autowired
	private RequestRepository repository;
	
	public Request placeRequest(Request request) {
		if(request.isValid())
			return repository.save(request);
		
		throw new IllegalArgumentException("request must be a valid non-null object");
	}

	public Request placeQuote(String requestId, Quote quote) {
		return null;
	}

	public List<Request> list(RequestState status, int offser, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Request> listAll() {
		return repository.findAll();
	}

}
