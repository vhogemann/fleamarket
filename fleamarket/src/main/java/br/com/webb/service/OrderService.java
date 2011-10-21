package br.com.webb.service;

import br.com.webb.model.Order;
import br.com.webb.model.Request;
import br.com.webb.model.User;

public interface OrderService {
	
	public Order placeOrder(Request request, User user);
	
	public Order cancelOrder(Order order, User user);

}
