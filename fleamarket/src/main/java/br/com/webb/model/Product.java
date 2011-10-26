package br.com.webb.model;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Document
public class Product extends AbstractEntity{

	private static final long serialVersionUID = 1L;

	private String description;
	private String name;
	private BigDecimal referencePrice;
	private String imageURL;
	private Set<String> tags;
	
	public Product() {}
	
	public Product(String name, String description, BigDecimal referencePrice) {
		this.referencePrice = referencePrice;
		this.name = name;
		this.description = description;
		if(!isValid())
			throw new IllegalStateException("Products needs both name and description");
	}
	
	public boolean isValid() {
		return isNotBlank(name) && isNotBlank(description) && referencePrice != null;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public BigDecimal getReferencePrice() {
		return referencePrice;
	}

	public void setReferencePrice(BigDecimal referencePrice) {
		this.referencePrice = referencePrice;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

}
