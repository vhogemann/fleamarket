package br.com.webb.repository;

import static junit.framework.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.webb.model.AbstractDocument;
import br.com.webb.model.AbstractEntity;

public abstract class AbstractMongoRepositoryTest<E extends AbstractDocument> {

	public abstract E newEntity();
	
	public abstract MongoRepository<E, String> getRepository();
	
	@Test
	public void testSave(){
		E expected = newEntity();
		
		String id = getRepository().save(expected).getId();
		
		AbstractEntity actual = getRepository().findOne(id);
		
		assertEquals(expected, actual);
	}
	
	@After
	public void resetRepository(){
		getRepository().deleteAll();
		afterResetHook();
	}
	
	public abstract void afterResetHook();
	
}
