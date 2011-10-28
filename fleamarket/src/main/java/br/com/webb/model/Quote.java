package br.com.webb.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;

import br.com.webb.model.item.Item;

public class Quote extends AbstractEntity implements Validatable, Comparable<Quote> {

	private Date createdAt;

	@DBRef(collection="supplier")
	private Supplier supplier;

	private List<Item> items;

	public Quote() { }
	
	public Quote(Supplier supplier, Request request) {
		this.supplier = supplier;
		
		for(Item item : request.getItems())
			getItems().add(item);
		
		this.createdAt = new Date();
	}

	public boolean isValid() {
		if(supplier != null && items != null && !items.isEmpty()){
			
			for(Item item : items)
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
		BigDecimal price = new BigDecimal(0.0);
		for(Item item : items){
			price = price.add(item.getPrice());
		}
		return price;
	}

	public List<Item> getItems() {
		if(items == null)
			items = new ArrayList<Item>();
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int compareTo(Quote o) {
		if(o.isValid())
			return getPrice().compareTo(o.getPrice());
		
		if(this.isValid())
			return -1;
		
		return 0;
	}

	@Override
	public String getId() {
		return getObjectId();
	}
	
}
