package br.com.webb.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;

import br.com.webb.model.common.Address;
import br.com.webb.model.item.RequestItem;
import br.com.webb.model.order.RequestHistoryItem;

public class Request extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	private Date createdAt;

	private Address deliveryAddress;

	private String description;

	private List<RequestHistoryItem> history;

	@DBRef
	private List<RequestItem> items;

	@DBRef
	private List<Order> orders;

	@DBRef
	private List<Quote> quotes;

	private RequestHistoryItem status;

	public Date getCreatedAt() {
		return createdAt;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public String getDescription() {
		return description;
	}

	public List<RequestHistoryItem> getHistory() {
		return history;
	}

	public List<RequestItem> getItems() {
		return items;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public List<Quote> getQuotes() {
		return quotes;
	}

	public RequestHistoryItem getStatus() {
		return status;
	}

	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setHistory(List<RequestHistoryItem> history) {
		this.history = history;
	}
	
	public void setItems(List<RequestItem> items) {
		this.items = items;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}

	public void setStatus(RequestHistoryItem status) {
		this.status = status;
	}

}
