package br.com.webb.model.order;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;

import br.com.webb.model.User;

public class RequestHistoryItem {

	private Date createdAt;
	
	private RequestStatus status;
	
	@DBRef
	private User updatedBy;
	
	private String description;

	public RequestHistoryItem() { }
	
	public RequestHistoryItem(RequestStatus status, User updatedBy, String description) {
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

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
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
