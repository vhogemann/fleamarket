package br.com.webb.model;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;

import br.com.webb.model.common.Address;
import br.com.webb.model.item.RequestItem;
import br.com.webb.model.order.RequestHistoryItem;
import br.com.webb.model.order.RequestStatus;

public class Request extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	private Date createdAt;

	private Address deliveryAddress;

	private String description;

	private List<RequestHistoryItem> history;

	@DBRef
	private List<RequestItem> items;

	@DBRef
	private Order order;

	@DBRef
	private List<Quote> quotes;

	private RequestHistoryItem status;

	public Request() { }
	
	public Request(Address deliveryAddress, String description) {
		this.deliveryAddress = deliveryAddress;
		this.description = description;
		this.createdAt = new Date();
		setStatus(new RequestHistoryItem(RequestStatus.DRAFT, "Nova requisição"));
		if(!isValid())
			throw new IllegalStateException("Valid Address and description are required");
	}

	public boolean isValid() {
		return isNotBlank(description) && deliveryAddress != null && deliveryAddress.isValid();
	}
	
	public void addQuote(Quote quote){
		if ( getItems().containsAll(quote.getItems()) &&
				getItems().size() == quote.getItems().size()){
			getQuotes().add(quote);
		} else
			throw new IllegalArgumentException("Quote must match every item described in the Request");
	}
	
	public void setOrder(Order order) {
		boolean valid = this.order == null &&
			status.getStatus().canChangeTo(RequestStatus.ORDERED) &&
			items.containsAll(order.getItems());
		
		if(valid) {
			this.order = order;
			setStatus(new RequestHistoryItem(RequestStatus.ORDERED, "Order placed"));
		} else
			throw new IllegalArgumentException("Order not placed, check Request and Order");
	}
	
	public void setStatus(RequestHistoryItem status) {
		if(this.status == null)
			this.status = status;
		else if (this.status.getStatus().canChangeTo(status.getStatus())){
			this.status = status;
			getHistory().add(status);
		} else
			throw new IllegalArgumentException("Invalid Status change");
	}
	
	// G&S -----------------------------------
	
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
		if(history == null)
			history = new ArrayList<RequestHistoryItem>();
		return history;
	}

	public List<RequestItem> getItems() {
		if(items == null)
			items = new ArrayList<RequestItem>();
		return items;
	}

	public Order getOrder() {
		return order;
	}

	public List<Quote> getQuotes() {
		if(quotes == null)
			quotes = new ArrayList<Quote>();
		return quotes;
	}

	public RequestHistoryItem getStatus() {
		return status;
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
	
	
	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}

}
