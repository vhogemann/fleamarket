package br.com.webb.model;

import java.io.Serializable;
import java.util.UUID;

public abstract class AbstractEntity implements Serializable, Validatable {

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
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof AbstractEntity)
			return objectId.equals(((AbstractEntity) obj).getObjectId());
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return objectId.hashCode();
	}
	
}
