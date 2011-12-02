package br.com.ideais.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import br.com.ideais.model.Supplier;
import br.com.ideais.model.common.Address;
import br.com.ideais.model.common.AddressType;
import br.com.ideais.repository.SupplierRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:test-context.xml")
public class SupplierRepositoryTest extends AbstractMongoRepositoryTest<Supplier> {

	@Autowired
	private SupplierRepository repository;
	
	@Test
	public void findByName(){
		repository.save(newEntity());
		
		List<Supplier> list = repository.findByName("Ideais Tecnologia");
		
		Assert.notEmpty(list);
	}
	
	@Override
	public Supplier newEntity() {
		Address address = new Address(
				"Rua da Assembleia", "98",
				null, "20011-000",
				"Brasil",
				"RJ", "Rio de Janeiro",
				AddressType.COMMERCIAL);
		return new Supplier("Ideais Tecnologia", address);
	}

	@Override
	public MongoRepository<Supplier, String> getRepository() {
		return repository;
	}

	@Override
	public void afterResetHook() {}

}
