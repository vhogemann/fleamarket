package br.com.webb.model.item;

import org.springframework.data.mongodb.core.mapping.DBRef;

import br.com.webb.model.Product;

public class AbstractItem implements Item {
	
	@DBRef
	private Product product;
	
	private int quantity;
	

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
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Item){
			Product product = ((Item)obj).getProduct();
			int quantity = ((Item)obj).getQuantity();
			return this.product.equals(product) && this.quantity == quantity; 
		}
		return false;
	}
}
