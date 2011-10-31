package br.com.webb.model.item;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.DBRef;

import br.com.webb.model.Product;

public class Item{
	
	@DBRef
	private Product product;
	
	private int quantity;
	
	private BigDecimal price;
	
	public Item() {}

	public Item(Product product, int quantity) {
		if(product.isValid()){
			this.product = product;
			this.quantity = quantity;
			this.price = product.getReferencePrice();
		} else 
			throw new IllegalArgumentException("Can't create Item from an invalid Product");
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Item){
			Item item = (Item) obj;
			if(item.isValid())
				return product.equals(item.getProduct());
		}
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return product.hashCode();
	}

	public boolean isValid() {
		return this.product != null;
	}
	
}
