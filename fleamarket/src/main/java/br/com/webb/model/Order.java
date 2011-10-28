package br.com.webb.model;

import java.math.BigDecimal;
import java.util.List;

import br.com.webb.model.item.Item;
import br.com.webb.model.order.OrderStatus;

public class Order extends AbstractEntity {
	
	private String id;
	
	private Quote quote;
	
	private OrderStatus status;
	
	private List<OrderStatus> history;
	
	public Order() { }
	
	public Order(Quote quote){
		if(!quote.isValid())
			throw new IllegalArgumentException("Can't create Order from an invalid Quote");
		
		this.quote = quote;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		BigDecimal total = new BigDecimal(0d);
		if(getItems() != null && !getItems().isEmpty())
			for(Item item : getItems())
				total = total.add(item.getPrice());
		return total;
	}

	public List<Item> getItems() {
		return quote.getItems();
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderStatus> getHistory() {
		return history;
	}

	public void setHistory(List<OrderStatus> history) {
		this.history = history;
	}

	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

	@Override
	public boolean isValid() {
		return quote.isValid();
	}
	
}
