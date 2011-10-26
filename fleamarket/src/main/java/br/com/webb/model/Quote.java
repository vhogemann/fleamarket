package br.com.webb.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;

import br.com.webb.model.item.QuoteItem;

public class Quote {

	private Date createdAt;

	@DBRef
	private Supplier supplier;

	@Transient
	private BigDecimal price;

	@DBRef
	private Request request;

	private List<QuoteItem> items;

	public Quote() { }
	
	public Quote(Supplier supplier, Request request) {
		this.supplier = supplier;
		this.request = request;
		this.createdAt = new Date();
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

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public List<QuoteItem> getItems() {
		return items;
	}

	public void setItems(List<QuoteItem> items) {
		this.items = items;
	}
}
