package br.com.webb.model;

import java.io.Serializable;

public abstract class AbstractDocument extends AbstractEntity implements Serializable, Validatable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof AbstractDocument)
			return objectId.equals(((AbstractDocument) obj).getObjectId());
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return objectId.hashCode();
	}
	
}
