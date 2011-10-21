package br.com.webb.model.item;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.DBRef;

import br.com.webb.model.Supplier;

public class OrderItem extends Item {
	
	private BigDecimal price;
	
	@DBRef
	private Supplier supplier;

}
