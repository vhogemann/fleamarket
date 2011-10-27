package br.com.webb.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;

import br.com.webb.model.item.QuoteItem;
import br.com.webb.model.item.RequestItem;

public class Quote implements Validatable {

	private Date createdAt;

	@DBRef
	private Supplier supplier;

	@Transient
	private BigDecimal price;

	private List<QuoteItem> items;

	public Quote() { }
	
	public Quote(Supplier supplier, Request request) {
		this.supplier = supplier;
		
		for(RequestItem item : request.getItems())
			getItems().add(new QuoteItem(item, null));
		
		this.createdAt = new Date();
	}

	public boolean isValid() {
		if(supplier != null && items != null && !items.isEmpty()){
			
			for(QuoteItem item : items)
				if (item.getPrice() == null) return false;
			
			return true;
		}

		return false;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<QuoteItem> getItems() {
		return items;
	}

	public void setItems(List<QuoteItem> items) {
		this.items = items;
	}

}
