package br.com.webb.model.item;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.DBRef;

import br.com.webb.model.Supplier;

public class OrderItem extends AbstractItem {
	
	private BigDecimal price;
	
	@DBRef
	private Supplier supplier;

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}
