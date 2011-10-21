package br.com.webb.model.item;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;

import br.com.webb.model.User;

public class ItemHistory {
	
	@DBRef
	private User createdBy;
	
	private ItemStatus status;
	
	private Date createdAt;
	
	private String description;

}
