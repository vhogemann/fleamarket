package br.com.webb.model.item;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.DBRef;

import br.com.webb.model.Supplier;

public class QuoteItem extends AbstractItem {
	
	private BigDecimal pricePerItem;
	
	@DBRef
	private Supplier supplier;

	public BigDecimal getPricePerItem() {
		return pricePerItem;
	}

	public void setPricePerItem(BigDecimal pricePerItem) {
		this.pricePerItem = pricePerItem;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}
