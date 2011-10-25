package br.com.webb.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.webb.model.item.OrderItem;

@Document
public class Order {
	
	private String id;
	
	@Transient
	private BigDecimal total;
	
	@DBRef
	private Request request;
	
	private List<OrderItem> items;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getTotal() {
		if(total == null){
			total = new BigDecimal(0d);
			if(items != null && !items.isEmpty())
				for(OrderItem item : items)
					total = total.add(item.getPrice());
		}
		return total;
	}


	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
}
