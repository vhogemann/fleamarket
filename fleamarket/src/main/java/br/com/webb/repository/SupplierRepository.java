package br.com.webb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.webb.model.Supplier;

@Repository
public interface SupplierRepository extends MongoRepository<Supplier, String> {
	
	List<Supplier> findByName(String name);
	Page<Supplier> findByName(String name, Pageable pageable);
	
	List<Supplier> findByNameLike(String name);
	Page<Supplier> findByNameLike(String name, Pageable pageable);

}
