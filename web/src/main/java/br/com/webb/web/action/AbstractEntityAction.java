package br.com.webb.web.action;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.webb.model.AbstractEntity;

public abstract class AbstractEntityAction <E extends AbstractEntity>{

	public abstract MongoRepository<E, String> getRepository();
	
	
	public String list(){
		
		return "success";
	}
	
}
