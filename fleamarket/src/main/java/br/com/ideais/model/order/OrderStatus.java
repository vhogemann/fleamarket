package br.com.ideais.model.order;

import java.util.Date;

public class OrderStatus {

	private Date createdAt;

	private OrderState status;

	private String description;

	public OrderStatus() {}

	public OrderStatus(OrderState status, String description) {
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

	public OrderState getStatus() {
		return status;
	}

	public void setStatus(OrderState status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
