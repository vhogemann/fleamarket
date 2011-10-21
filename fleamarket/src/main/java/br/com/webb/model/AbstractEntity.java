package br.com.webb.model;

import java.io.Serializable;
import java.util.UUID;

public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String objectId = UUID.randomUUID().toString();

	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	
}
