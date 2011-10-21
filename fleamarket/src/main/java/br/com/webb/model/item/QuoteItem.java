package br.com.webb.model.item;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.DBRef;

import br.com.webb.model.Supplier;

public class QuoteItem extends Item {
	
	private BigDecimal pricePerItem;
	
	@DBRef
	private Supplier supplier;

}
