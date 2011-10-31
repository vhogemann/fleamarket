package br.com.webb.model;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

import br.com.webb.model.common.Address;
import br.com.webb.model.item.Item;
import br.com.webb.model.order.RequestState;
import br.com.webb.model.order.RequestStatus;

public class Request extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private Date createdAt;

	private Address deliveryAddress;

	private String description;

	private List<RequestStatus> history;

	private List<Item> items;

	private Order order;

	private List<Quote> quotes;

	private RequestStatus status;

	public Request() {
		createdAt = new Date();
		deliveryAddress = new Address();
		setStatus(new RequestStatus(RequestState.DRAFT, "Nova requisição"));
	}

	public Request(Address deliveryAddress, String description) {
		this.deliveryAddress = deliveryAddress;
		this.description = description;
		this.createdAt = new Date();
		setStatus(new RequestStatus(RequestState.DRAFT, "Nova requisição"));
		if (!isValid())
			throw new IllegalStateException(
					"Valid Address and description are required");
	}

	public boolean isValid() {
		return isNotBlank(description) && deliveryAddress != null
				&& deliveryAddress.isValid();
	}

	public void addProduct(Product product, int quantity) {
		
		quantity = quantity == 0 ? 1 : quantity;
		
		if (getStatus().getState().equals(RequestState.DRAFT)) {
			Item item = new Item(product, quantity);
			
			if(getItems().contains(item)){
				Item oldItem = getItems().get(getItems().indexOf(item));
				oldItem.setQuantity(oldItem.getQuantity() + 1);
			} else
				getItems().add(item);
		} else
			throw new IllegalStateException(
					"Can't add products to a non-DRAFT request");
	}

	public void addQuote(Quote quote) {

		if (status.getState().equals(RequestState.PENDING_QUOTES))
			getQuotes().add(quote);
		else
			throw new IllegalStateException("Can't add quotes on state: "
					+ getStatus().getState().name());
	}

	public void setOrder(Order order) {
		boolean valid = this.order == null
				&& status.getState().canChangeTo(RequestState.ORDERED);

		if (valid) {
			this.order = order;
			setStatus(new RequestStatus(RequestState.ORDERED, "Order placed"));
		} else
			throw new IllegalStateException(
					"Order not placed, check Request and Order");
	}

	public void setStatus(RequestStatus status) {
		if (this.status == null) {
			this.status = status;
			getHistory().add(status);
		} else if (this.status.getState().canChangeTo(status.getState())) {
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

	public List<RequestStatus> getHistory() {
		if (history == null)
			history = new ArrayList<RequestStatus>();
		return history;
	}

	public List<Item> getItems() {
		if (items == null)
			items = new ArrayList<Item>();
		return items;
	}

	public Order getOrder() {
		return order;
	}

	public List<Quote> getQuotes() {
		if (quotes == null)
			quotes = new ArrayList<Quote>();
		return quotes;
	}

	public RequestStatus getStatus() {
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

	public void setHistory(List<RequestStatus> history) {
		this.history = history;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
