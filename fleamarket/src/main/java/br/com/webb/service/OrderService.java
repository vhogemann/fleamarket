package br.com.webb.service;

import java.util.List;

import br.com.webb.model.Order;
import br.com.webb.model.Request;
import br.com.webb.model.order.OrderStatus;

public interface OrderService {
	
	public Order placeOrder(Request request);
	
	public Order updateOrderStatus(Order order, OrderStatus status, String message);
	
	public List<Order> list(OrderStatus status, int offset, int limit );

}
