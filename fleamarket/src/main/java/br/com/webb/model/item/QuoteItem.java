package br.com.webb.model.item;

import java.math.BigDecimal;

import br.com.webb.model.Product;

public class QuoteItem extends AbstractItem {
	
	private BigDecimal pricePerItem;
	
	public QuoteItem() {}
	
	
	public QuoteItem(Product product, int quantity, BigDecimal pricePerItem) {
		this.pricePerItem = pricePerItem;
		setProduct(product);
		setQuantity(quantity);
	}

	public BigDecimal getPricePerItem() {
		return pricePerItem;
	}

	public void setPricePerItem(BigDecimal pricePerItem) {
		this.pricePerItem = pricePerItem;
	}


}
