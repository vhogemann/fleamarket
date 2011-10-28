package br.com.webb.model;

import java.util.UUID;

public class AbstractEntity {

	protected String objectId = UUID.randomUUID().toString();

	public AbstractEntity() {
		super();
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

}