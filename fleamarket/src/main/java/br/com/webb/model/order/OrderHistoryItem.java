package br.com.webb.model.order;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;

import br.com.webb.model.User;

public class OrderHistoryItem {

	private Date createdAt;

	private OrderStatus status;

	@DBRef
	private User updatedBy;

	private String description;

	public OrderHistoryItem() {}

	public OrderHistoryItem(OrderStatus status, User updatedBy, String description) {
		super();
		this.status = status;
		this.updatedBy = updatedBy;
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

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
