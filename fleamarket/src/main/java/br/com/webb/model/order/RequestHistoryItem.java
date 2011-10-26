package br.com.webb.model.order;

import java.util.Date;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import br.com.webb.model.Validatable;

public class RequestHistoryItem implements Validatable {

	private Date createdAt;
	
	private RequestStatus status;
	
	private String description;

	public RequestHistoryItem() { }
	
	public RequestHistoryItem(RequestStatus status, String description) {
		this.status = status;
		this.description = description;
		this.createdAt = new Date();
	}
	
	public boolean isValid() {
		return isNotBlank(description) && status != null;
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
