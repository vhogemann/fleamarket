package br.com.webb.model.item;

import java.math.BigDecimal;

public class RequestItem extends AbstractItem {
	
	private BigDecimal maximumPrice;
	
	private boolean required;
	
	private String description;

	public BigDecimal getMaximumPrice() {
		return maximumPrice;
	}

	public void setMaximumPrice(BigDecimal maximumPrice) {
		this.maximumPrice = maximumPrice;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
