package br.com.webb.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.webb.model.item.OrderItem;

@Document
public class Order {
	
	private String id;
	
	@DBRef
	private User owner;
	
	@DBRef
	private Request request;
	
	private List<OrderItem> items;
	
}
