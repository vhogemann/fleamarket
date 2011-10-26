package br.com.webb.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import br.com.webb.model.item.QuoteItem;
import br.com.webb.model.order.OrderHistoryItem;

@Document
public class Order {
	
	private String id;
	
	private List<QuoteItem> items;
	
	private OrderHistoryItem status;
	
	private List<OrderHistoryItem> history;
	
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

	public List<QuoteItem> getItems() {
		return items;
	}

	public void setItems(List<QuoteItem> items) {
		this.items = items;
	}

	public OrderHistoryItem getStatus() {
		return status;
	}

	public void setStatus(OrderHistoryItem status) {
		this.status = status;
	}

	public List<OrderHistoryItem> getHistory() {
		return history;
	}

	public void setHistory(List<OrderHistoryItem> history) {
		this.history = history;
	}
	
}
