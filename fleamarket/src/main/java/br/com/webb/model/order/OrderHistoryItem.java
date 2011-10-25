package br.com.webb.model.order;

import java.util.Date;

public class OrderHistoryItem {

	private Date createdAt;

	private OrderStatus status;

	private String description;

	public OrderHistoryItem() {}

	public OrderHistoryItem(OrderStatus status, String description) {
		super();
		this.status = status;
		this.description = description;
		this.createdAt = new Date();
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
