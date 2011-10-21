package br.com.webb.model.item;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.webb.model.Product;

@Document
public class Item {
	
	@DBRef
	private Product product;
	
	private int quantity;
	
	private List<ItemHistory> history;
	
}
