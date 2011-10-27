package br.com.webb.model.item;

import java.math.BigDecimal;

public class QuoteItem extends RequestItem {
	
	private BigDecimal price;
	
	public QuoteItem() {}
	
	public QuoteItem(Item item, BigDecimal pricePerItem){
		setProduct(item.getProduct());
		setQuantity(item.getQuantity());
		if(pricePerItem != null)
			this.price = pricePerItem;
		else
			this.price = item.getProduct().getReferencePrice();
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal pricePerItem) {
		this.price = pricePerItem;
	}

}
