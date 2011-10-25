package br.com.webb.model.order;

import java.util.Date;

public class RequestHistoryItem {

	private Date createdAt;
	
	private RequestStatus status;
	
	private String description;

	public RequestHistoryItem() { }
	
	public RequestHistoryItem(RequestStatus status, String description) {
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

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
