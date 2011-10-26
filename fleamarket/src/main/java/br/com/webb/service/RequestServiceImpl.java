package br.com.webb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.webb.model.Quote;
import br.com.webb.model.Request;
import br.com.webb.model.item.RequestItem;
import br.com.webb.model.order.RequestStatus;

@Service
public class RequestServiceImpl implements RequestService {

	
	public Request placeRequest(List<RequestItem> items, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	public Request placeQuote(Request request, Quote quote) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Request> list(RequestStatus status, int offser, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

}
