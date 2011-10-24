package br.com.webb.model.item;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;

import br.com.webb.model.Product;

public class AbstractItem {
	
	@DBRef
	private Product product;
	
	private int quantity;
	
	private List<ItemHistory> history;

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

	public List<ItemHistory> getHistory() {
		return history;
	}

	public void setHistory(List<ItemHistory> history) {
		this.history = history;
	}
	
}
