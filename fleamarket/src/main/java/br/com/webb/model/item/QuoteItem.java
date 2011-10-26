package br.com.webb.model.item;

import java.math.BigDecimal;

public class QuoteItem extends AbstractItem {
	
	private BigDecimal price;
	
	public QuoteItem() {}
	
	public QuoteItem(RequestItem item, BigDecimal pricePerItem){
		setProduct(item.getProduct());
		setQuantity(item.getQuantity());
		this.price = pricePerItem;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal pricePerItem) {
		this.price = pricePerItem;
	}

}
