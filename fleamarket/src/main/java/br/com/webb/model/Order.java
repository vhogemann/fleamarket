package br.com.webb.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import br.com.webb.model.item.QuoteItem;
import br.com.webb.model.order.OrderStatus;

public class Order {
	
	private String id;
	
	private Set<QuoteItem> items;
	
	private OrderStatus status;
	
	private List<OrderStatus> history;
	
	public Order() { }
	
	public Order(Quote quote){
		if(!quote.isValid())
			throw new IllegalArgumentException("Can't create Order from an invalid Quote");
		
		this.items = quote.getItems();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getTotal() {
		BigDecimal total = new BigDecimal(0d);
		if(items != null && !items.isEmpty())
			for(QuoteItem item : items)
				total = total.add(item.getPrice());
		return total;
	}

	public Set<QuoteItem> getItems() {
		return items;
	}

	public void setItems(Set<QuoteItem> items) {
		this.items = items;
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
	
}
