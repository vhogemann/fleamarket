package br.com.webb.model;

import java.util.UUID;

public abstract class AbstractEntity {

	protected String objectId = UUID.randomUUID().toString();

	public abstract String getId();
	
	public abstract boolean isValid();
	
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