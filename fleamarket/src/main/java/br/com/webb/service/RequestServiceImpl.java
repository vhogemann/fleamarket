package br.com.webb.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webb.model.Order;
import br.com.webb.model.Quote;
import br.com.webb.model.Request;
import br.com.webb.model.order.RequestState;
import br.com.webb.model.order.RequestStatus;
import br.com.webb.repository.RequestRepository;

@Service
public class RequestServiceImpl implements RequestService {
	
	@Autowired
	private RequestRepository repository;

	public void publish(String id, String reason) {
		changeStatus(id, reason, RequestState.PENDING_APPROVAL);
	}

	public void approve(String id, String reason) {
		changeStatus(id, reason, RequestState.PENDING_QUOTES);
	}

	public void cancel(String id, String reason) {
		changeStatus(id, reason, RequestState.CANCELED);
	}

	public void endQuoting(String id, String reason) {
		changeStatus(id, reason, RequestState.PENDING_ORDER);
	}

	public Order approveBestQuote(String requestId) {
		Request request = repository.findOne(requestId);
		if(request == null)
			throw new IllegalArgumentException("Id not found on persistence");
		if(request.getQuotes() == null || request.getQuotes().isEmpty())
			throw new IllegalStateException("No quotes for this request");
		Collections.sort(request.getQuotes());
		Quote quote = request.getQuotes().get(0);
		Order order = new Order(quote);
		request.setOrder(order);
		repository.save(request);
		return order;
	}

	public Order approveQuote(String requestId, String quoteId) {
		Request request = repository.findOne(requestId);
		Quote quote = null;
		for(Quote q : request.getQuotes()){
			if(q.getObjectId().equals(quoteId)){
				quote = q;
				break;
			}
		}
		
		if(quote == null)
			throw new IllegalArgumentException("Invalid quoteId");
		
		Order order = new Order(quote);
		request.setOrder(order);
		repository.save(request);
		return order;
	}
	
	private void changeStatus(String requestId, String reason, RequestState state){
		Request request = repository.findOne(requestId);
		if(request != null){
			RequestStatus status = new RequestStatus(state, reason);
			request.setStatus(status);
			repository.save(request);
		} else
			throw new IllegalArgumentException("Id not found on persistence");
	}
	

}
