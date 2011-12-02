package br.com.ideais.model;

import java.io.Serializable;
import java.util.UUID;

public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

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