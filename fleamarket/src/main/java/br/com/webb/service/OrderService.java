package br.com.webb.service;

import java.util.List;

import br.com.webb.model.Order;
import br.com.webb.model.Request;
import br.com.webb.model.order.OrderState;

public interface OrderService {
	
	public Order placeOrder(Request request);
	
	public Order updateOrderStatus(Order order, OrderState status, String message);
	
	public List<Order> list(OrderState status, int offset, int limit );

}
