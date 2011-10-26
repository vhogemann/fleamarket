package br.com.webb.repository;

import org.junit.Test;
import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.webb.model.AbstractEntity;

import static junit.framework.Assert.*;

public abstract class AbstractMongoRepositoryTest<E extends AbstractEntity> {

	public abstract E newEntity();
	
	public abstract MongoRepository<E, String> getRepository();
	
	@Test
	public void testSave(){
		E expected = newEntity();
		
		String id = getRepository().save(expected).getId();
		
		E actual = getRepository().findOne(id);
		
		assertEquals(expected, actual);
	}
	
}
