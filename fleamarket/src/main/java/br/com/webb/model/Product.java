package br.com.webb.model;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Document
public class Product extends AbstractEntity{

	private static final long serialVersionUID = 1L;

	private String description;
	private String name;
	private Set<String> tags;
	
	public Product() {}
	
	public Product(String name, String description) {
		this.name = name;
		this.description = description;
		if(!isValid())
			throw new IllegalStateException("Products needs both name and description");
	}
	
	public boolean isValid() {
		return isNotBlank(name) && isNotBlank(description);
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

}
