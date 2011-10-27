package br.com.webb.web.action;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.webb.model.AbstractEntity;

import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractEntityAction <E extends AbstractEntity> extends ActionSupport{

	private static final long serialVersionUID = 8466293955457016376L;
	protected static final String FAILURE = "failure";
	protected static final String SUCCESS = "success";

	protected String entityId;
	protected List<E> entities;
	
	private int currentPage;
	private int pageSize = 10;
		
	private MongoRepository<E, String> repository;
	
	private String staticURLBase;
	
	protected E entity;
	
	
	public String execute(){
		return SUCCESS;
	}
	
	public String show(){
		if(isNotBlank(entityId))
			entity = getRepository().findOne(entityId);
		
		if(entity != null)
			return SUCCESS;
		
		return FAILURE;
		
	}
	
	public String list(){
		entities = getRepository().findAll();
		return SUCCESS;
	}
	
	public String create(){
		entity =  newEntity();
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
		Collection<String> errorMessages = new ArrayList<String>();
		errorMessages.add("Entity is not Valid!");
		this.setActionErrors(errorMessages );
		return INPUT;
		
	}
	
	public String update(){
		
		if(entity.isValid()){
			getRepository().save(entity);
			return SUCCESS;
		} 
		Collection<String> errorMessages = new ArrayList<String>();
		errorMessages.add("Entity is not Valid!");
		this.setActionErrors(errorMessages );
		return INPUT;
	}
	
	public String delete(){
		
		getRepository().delete(entity);
		
		return SUCCESS;
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

	public MongoRepository<E, String> getRepository() {
		return repository;
	}

	public void setRepository(MongoRepository<E, String> repository) {
		this.repository = repository;
	}

	public String getStaticURLBase() {
		return staticURLBase;
	}

	public void setStaticURLBase(String staticURLBase) {
		this.staticURLBase = staticURLBase;
	}

	public List<E> getEntities() {
		return entities;
	}

	public void setEntities(List<E> entities) {
		this.entities = entities;
	}

}
