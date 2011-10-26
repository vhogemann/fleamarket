package br.com.webb.web.action;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.webb.model.AbstractEntity;

public abstract class AbstractEntityAction <E extends AbstractEntity>{

	protected static final String FAILURE = "failure";
	protected static final String SUCCESS = "success";

	protected String entityId;
	protected E entity;
	protected Page<E> page;
	
	private int currentPage;
	private int pageSize = 10;
	
	public abstract MongoRepository<E, String> getRepository();

	public String show(){
		if(isNotBlank(entityId))
			entity = getRepository().findOne(entityId);
		
		if(entity != null)
			return SUCCESS;
		
		return FAILURE;
		
	}
	
	public String list(){
		page = getRepository().findAll(new PageRequest(currentPage, pageSize));
		return SUCCESS;
	}
	
	public String create(){
		entity = newEntity();
		return SUCCESS;
	}
	
	public String edit(){
		if(isNotBlank(entityId))
			entity = getRepository().findOne(entityId);

		if(entity != null)
			return SUCCESS;
		
		return FAILURE;
	}
	
	public String save(){
		
		if(entity.isValid()){
			getRepository().save(entity);
			return SUCCESS;
		} 
		
		return FAILURE;
		
	}
	
	/**
	 * This method should return a blank entity
	 * ready to be populated by the user using
	 * the form. It's useful to give a chance of 
	 * setting automatic values such as creation
	 * date before sending them to the view.
	 * 
	 * @return
	 */
	protected abstract E newEntity();
	
	// G&S ----------------- 
	
	public void setEntityId(String entityId){
		this.entityId = entityId;
	}


	public E getEntity() {
		return entity;
	}


	public void setEntity(E entity) {
		this.entity = entity;
	}


	public Page<E> getPage() {
		return page;
	}


	public void setPage(Page<E> page) {
		this.page = page;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
