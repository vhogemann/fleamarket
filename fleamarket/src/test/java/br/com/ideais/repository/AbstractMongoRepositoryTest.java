package br.com.ideais.repository;

import static junit.framework.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ideais.model.AbstractEntity;

public abstract class AbstractMongoRepositoryTest<E extends AbstractEntity> {

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
