package br.com.webb.model.order;

import java.util.Date;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import br.com.webb.model.Validatable;

public class RequestStatus implements Validatable {

	private Date createdAt;
	
	private RequestState state;
	
	private String description;

	public RequestStatus() { }
	
	public RequestStatus(RequestState status, String description) {
		this.state = status;
		this.description = description;
		this.createdAt = new Date();
	}
	
	public boolean isValid() {
		return isNotBlank(description) && state != null;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public RequestState getState() {
		return state;
	}

	public void setState(RequestState status) {
		this.state = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
