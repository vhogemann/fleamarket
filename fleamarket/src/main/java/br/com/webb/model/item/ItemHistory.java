package br.com.webb.model.item;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;

import br.com.webb.model.User;

public class ItemHistory {
	
	@DBRef
	private User createdBy;
	
	private ItemStatus status;
	
	private Date createdAt;
	
	private String description;

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public ItemStatus getStatus() {
		return status;
	}

	public void setStatus(ItemStatus status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
