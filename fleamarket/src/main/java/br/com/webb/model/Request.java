package br.com.webb.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;

import br.com.webb.model.common.Address;
import br.com.webb.model.item.RequestItem;
import br.com.webb.model.order.RequestHistoryItem;

public class Request extends AbstractEntity {
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RequestHistoryItem getStatus() {
		return status;
	}

	public void setStatus(RequestHistoryItem status) {
		this.status = status;
	}

	public List<RequestItem> getItems() {
		return items;
	}

	public void setItems(List<RequestItem> items) {
		this.items = items;
	}

	public List<Quote> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<RequestHistoryItem> getHistory() {
		return history;
	}

	public void setHistory(List<RequestHistoryItem> history) {
		this.history = history;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	private static final long serialVersionUID = 1L;

	private Date createdAt;
	
	@DBRef
	private User createdBy;
	
	private String description;
	
	private RequestHistoryItem status;
	
	@DBRef
	private List<RequestItem> items;
	
	@DBRef
	private List<Quote> quotes;
	
	@DBRef
	private List<Order> orders;
	
	private List<RequestHistoryItem> history;
	
	private Address deliveryAddress;

}
